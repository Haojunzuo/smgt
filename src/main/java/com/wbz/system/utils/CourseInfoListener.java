package com.wbz.system.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.wbz.system.domain.CourseInfo;
import com.wbz.system.service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseInfoListener extends AnalysisEventListener<CourseInfo> {
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private CourseService courseService;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param courseService
     */
    public CourseInfoListener(CourseService courseService) {
        this.courseService = courseService;
    }

    public CourseInfoListener(){}
    /**
     * 每隔100条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<CourseInfo> list = new ArrayList<CourseInfo>();

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param courseInfo
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param analysisContext
     */
    @Override
    public void invoke(CourseInfo courseInfo, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据:{}"+ JSON.toJSONString(courseInfo));
        list.add(courseInfo);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("导入成功了");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        courseService.insertCourseByBatch(list);
        System.out.println("存储数据库成功！");
    }


}
