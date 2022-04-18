package com.wbz.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.wbz.system.domain.*;
import com.wbz.system.service.ClassTaskService;
import com.wbz.system.service.CourseService;
import com.wbz.system.utils.GeneralListener;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/classTask")
public class ClassTaskController {

    @Autowired
    private ClassTaskService classTaskService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public TableDataInfo list(ClassTask classTask){
        Integer pageNum = classTask.getPageNum();
        Integer pageSize = classTask.getPageSize();
        String orderBy = classTask.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<ClassTask> classTaskList = classTaskService.selectClassTaskList(classTask);
        return PageUtils.getMyDataTable(classTaskList);
    }

    @PutMapping("/checkCourseExist")
    public String checkCourseExist(ClassTask classTask){
        return classTaskService.checkCourseExist(classTask);
    }
    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
    @PostMapping
    public AjaxResult add(ClassTask classTask){
        System.out.println(classTask.toString());
        return toAjax(classTaskService.insertClassTask(classTask));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody ClassTask classTask){
        System.out.println("edit classTask");
        System.out.println(classTask.toString());
        return toAjax(classTaskService.updateClassTask(classTask));
    }

    @RequestMapping("/{id}")
    public AjaxResult getClassTask(@PathVariable("id") Long id){
        return AjaxResult.success(classTaskService.selectClassTaskById(id));
    }

    @RequestMapping("/listCoursePlan")
    public TableDataInfo listCoursePlan(CoursePlan coursePlan){
        Integer pageNum = coursePlan.getPageNum();
        Integer pageSize = coursePlan.getPageSize();
        String orderBy = coursePlan.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<CoursePlan> coursePlanList = classTaskService.selectCoursePlanList(coursePlan);
        return PageUtils.getMyDataTable(coursePlanList);
    }

    @DeleteMapping("/{ids}")
    public AjaxResult delClassTask(@PathVariable("ids") Long[] ids){
        return toAjax(classTaskService.delClassTask(ids));
    }

    @PostMapping("/importClassTask")
    public AjaxResult importClassTask(MultipartFile file) throws Exception{
        GeneralListener<ClassTask> generalListener = new GeneralListener<>();
        EasyExcel.read(file.getInputStream(),ClassTask.class,generalListener).sheet().doRead();
        List<ClassTask> classTaskList = generalListener.getList();
        classTaskService.insertClassTaskByBatch(classTaskList);
        return AjaxResult.success();
    }
    @PostMapping("/exportClassTask")
    public void exportCourse(HttpServletResponse response, ClassTask classTask) throws IOException {
        List<ClassTask> list = classTaskService.selectClassTaskList(classTask);
        List<ClassTask> exportList = JSON.parseArray(JSON.toJSONString(list),ClassTask.class);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String filePrefix="测试文件";
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(filePrefix, "UTF-8").replaceAll("\\+", "%20");
            //Content-disposition 的 attachment参数将文件作为附件下载
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), ClassTask.class).sheet("模板").doWrite(exportList);
        } catch (Exception e) {
            System.out.println("下载文件失败!"+e);
        }
    }

    @PostMapping("/schedule/{semester}")
    public AjaxResult arrange(@PathVariable("semester") String semester) {
        ClassTask classTask = new ClassTask();
        classTask.setSemester(semester);
        System.out.println(classTask);
        return toAjax(courseService.classScheduling(classTask));
    }
}
