package com.wbz.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.analysis.ExcelAnalyser;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.fastjson.JSON;
import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.CourseInfo;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.mapper.CourseInfoMapper;
import com.wbz.system.service.CourseService;
import com.wbz.system.utils.CourseInfoListener;
import com.wbz.system.utils.GeneralListener;
import com.wbz.system.utils.PageUtils;
import com.wbz.system.utils.UploadDataListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseInfoMapper courseInfoMapper;


    @RequestMapping("/list")
    public TableDataInfo list(CourseInfo courseInfo){
        Integer pageNum = courseInfo.getPageNum();
        Integer pageSize = courseInfo.getPageSize();
        String orderBy = courseInfo.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<CourseInfo> courseInfoList = courseService.selectCourseInfoList(courseInfo);
        return PageUtils.getMyDataTable(courseInfoList);
    }
    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping
    public AjaxResult add(@RequestBody CourseInfo courseInfo){
        System.out.println(courseInfo.toString());
        return toAjax(courseService.insertCourse(courseInfo));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody CourseInfo courseInfo){
        return toAjax(courseService.updateCourse(courseInfo));
    }

    @PutMapping("/checkno/{courseno}")
    public String checkno(@PathVariable("courseno") String courseno, @RequestBody CourseInfo courseInfo){
        return courseService.checkno(courseno,courseInfo);
    }

    @RequestMapping("/{id}")
    public AjaxResult getCourse(@PathVariable("id") Long id){
        return AjaxResult.success(courseService.selectCourseById(id));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult delCourse(@PathVariable Long []ids){
        return toAjax(courseService.delCourse(ids));
    }

    @PostMapping("/importCourse")
    public AjaxResult importCourse(MultipartFile file) throws Exception{
//        1、使用实现ReadListener的方式
//        EasyExcel.read(file.getInputStream(),CourseInfo.class, new UploadDataListener(courseInfoMapper)).sheet().doRead();
//        2、使用继承AnalysisEventListener的方式
//        EasyExcel.read(file.getInputStream(), CourseInfo.class,new CourseInfoListener(courseService)).sheet().doRead();
//        3、使用继承AnalysisEventListener且使用泛型的方式：
        GeneralListener<CourseInfo> generalListener = new GeneralListener<>();
        EasyExcel.read(file.getInputStream(),CourseInfo.class,generalListener).sheet().doRead();
        List<CourseInfo> courseInfoList = generalListener.getList();
        courseService.insertCourseByBatch(courseInfoList);
        return AjaxResult.success();
    }

    @PostMapping("/exportCourse")
    public void exportCourse(HttpServletResponse response, CourseInfo courseInfo) throws IOException{
        List<CourseInfo> list = courseService.selectCourseInfoList(courseInfo);
        List<CourseInfo> exportList = JSON.parseArray(JSON.toJSONString(list),CourseInfo.class);
        for (CourseInfo info : exportList) {
            System.out.println(info.toString());
        }
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String filePrefix="测试文件";
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(filePrefix, "UTF-8").replaceAll("\\+", "%20");
            //Content-disposition 的 attachment参数将文件作为附件下载
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), CourseInfo.class).sheet("模板").doWrite(exportList);
        } catch (Exception e) {
            System.out.println("下载文件失败!"+e);
        }
        System.out.println("下载数据大小为:{}");
        System.out.println(exportList.size());
    }



}
