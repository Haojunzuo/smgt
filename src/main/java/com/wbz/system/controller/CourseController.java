package com.wbz.system.controller;

import com.wbz.system.domain.CourseInfo;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.CourseService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @RequestMapping("/list")
    public TableDataInfo list(CourseInfo courseInfo){
        System.out.println(courseInfo.getCourseno());
        Integer pageNum = courseInfo.getPageNum();
        Integer pageSize = courseInfo.getPageSize();
        String orderBy = courseInfo.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<CourseInfo> courseInfoList = courseService.selectCourseInfoList(courseInfo);
        for (CourseInfo info : courseInfoList) {
            System.out.println(info.getCoursename()+info.getCourseno());
        }
        TableDataInfo myDataTable = PageUtils.getMyDataTable(courseInfoList);
        System.out.println("hhh");
        System.out.println(myDataTable.getRows());
        return PageUtils.getMyDataTable(courseInfoList);
    }

}
