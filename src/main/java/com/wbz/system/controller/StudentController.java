package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Student;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.StudentService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


//    @PostMapping("/importData")
//    @ResponseBody
//    public AjaxResult importData(MultipartFile file) throws Exception
//    {
//        //SupplierPriceManagement这里改为自己的实体类
//        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
//        List<Student> list = util.importExcel(file.getInputStream());
//        //这里调用自己的service处理导入数据
//        StudentService.importStudent(list);
//        return AjaxResult.success();
//    }
}
