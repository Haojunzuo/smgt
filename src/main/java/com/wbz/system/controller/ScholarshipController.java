package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Scholarship;
import com.wbz.system.domain.StuScholarship;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.ScholarshipService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scholarship")
public class ScholarshipController {
    @Autowired
    private ScholarshipService scholarshipService;

    @RequestMapping("/list")
    public TableDataInfo list(StuScholarship stuScholarship){
        System.out.println(stuScholarship.toString());
        Integer pageNum = stuScholarship.getPageNum();
        Integer pageSize = stuScholarship.getPageSize();
        String orderBy = stuScholarship.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<Scholarship> list = scholarshipService.selectStuScholarshipList(stuScholarship);
        return PageUtils.getMyDataTable(list);
    }
    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @DeleteMapping("/{id}")
    public AjaxResult del(@PathVariable("id") Long id){
        return toAjax(scholarshipService.delScholarship(id));
    }

    @PutMapping
    public AjaxResult update(@RequestBody StuScholarship stuScholarship){
        return toAjax(scholarshipService.updateScholarship(stuScholarship));
    }

    @RequestMapping("/{id}")
    public AjaxResult getScholarship(@PathVariable("id") Long id){
        return AjaxResult.success(scholarshipService.getScholarship(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody StuScholarship stuScholarship){
        return AjaxResult.success(scholarshipService.insertScholarship(stuScholarship));
    }

}
