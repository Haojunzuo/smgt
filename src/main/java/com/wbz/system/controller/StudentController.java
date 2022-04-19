package com.wbz.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.wbz.system.domain.*;
import com.wbz.system.service.StudentService;
import com.wbz.system.utils.GeneralListener;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/list")
    public TableDataInfo list(Student student) {
        System.out.println(student.toString());
        Integer pageNum = student.getPageNum();
        Integer pageSize = student.getPageSize();
        String orderBy = student.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<Student> list = studentService.selectStudentList(student);
        return PageUtils.getMyDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(studentService.selectStudentByUserId(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody Student student) {
        return toAjax(studentService.insertStudent(student));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Student student) {
        System.out.println(student.toString());
        return toAjax(studentService.updateStudent(student));
    }

	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(studentService.deleteStudentByIds(ids));
    }


    @PostMapping("/importStudent")
    public AjaxResult importStudents(MultipartFile file) throws Exception{
        System.out.println("importStudent");
        GeneralListener<Student> generalListener = new GeneralListener<>();
        EasyExcel.read(file.getInputStream(),Student.class,generalListener).sheet().doRead();
        List<Student> studentList = generalListener.getList();
        studentService.insertStudentByBatch(studentList);
        return AjaxResult.success();
    }

    @PostMapping("/exportStudent")
    public void exportStudent(HttpServletResponse response, Student student) throws Exception {
        List<Student> studentList = studentService.selectStudentList(student);
        List<Student> exportList = JSON.parseArray(JSON.toJSONString(studentList), Student.class);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String filePrefix = "测试文件";
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(filePrefix, "UTF-8").replaceAll("\\+", "%20");
            //Content-disposition 的 attachment参数将文件作为附件下载
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), Student.class).sheet("模板").doWrite(exportList);
        } catch (Exception e) {
            System.out.println("下载文件失败!" + e);
        }
    }
}
