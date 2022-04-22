package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.StudentElCourse;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.mapper.ElCourseMapper;
import com.wbz.system.service.StudentElCourseService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/studentElCourse")
public class StudentElCourseController {

    @Autowired
    private StudentElCourseService studentElCourseService;

    @Autowired
    private ElCourseMapper elCourseMapper;
//    @GetMapping("/list")
//    public TableDataInfo list(StudentElCourse StudentElCourse) {
//        Integer pageNum = StudentElCourse.getPageNum();
//        Integer pageSize = StudentElCourse.getPageSize();
//        String orderBy = StudentElCourse.getOrderBy();
//        PageUtils.startMyPage(pageNum, pageSize, orderBy);
//        List<StudentElCourse> list = studentElCourseService.selectStudentElCourseByStudentNo(StudentElCourse.getStudentNo());
//        return PageUtils.getMyDataTable(list);
//    }

    @GetMapping(value = "/{studentNo}")
    public AjaxResult getInfo(@PathVariable("studentNo") String studentNo)
    {
        return AjaxResult.success(studentElCourseService.selectStudentElCourseByStudentNo(studentNo));
    }

    @PostMapping
    public AjaxResult add(@RequestBody StudentElCourse studentElCourse) {
        elCourseMapper.updateElCourseById(studentElCourse.getElCourse());
        return toAjax(studentElCourseService.insertStudentElCourse(studentElCourse));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody StudentElCourse StudentElCourse) {
        return toAjax(studentElCourseService.updateStudentElCourse(StudentElCourse));
    }

    @PostMapping("/del")
    public AjaxResult remove(@RequestBody StudentElCourse studentElCourse) {
        elCourseMapper.updateElCourseByIdDel(studentElCourse.getElCourse());
        return toAjax(studentElCourseService.deleteStudentElCourseById(studentElCourse));
    }


}
