package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Exam;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.ExamService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService ExamService;


    @GetMapping("/list")
    public TableDataInfo list(Exam Exam) {
        System.out.println(Exam.toString());
        Integer pageNum = Exam.getPageNum();
        Integer pageSize = Exam.getPageSize();
        String orderBy = Exam.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<Exam> list = ExamService.selectExamList(Exam);
        return PageUtils.getMyDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ExamService.selectExamByStudentId(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody Exam Exam) {
        return toAjax(ExamService.insertExam(Exam));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Exam Exam) {
        System.out.println(Exam.toString());
        return toAjax(ExamService.updateExam(Exam));
    }

	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(ExamService.deleteExamByIds(ids));
    }

}
