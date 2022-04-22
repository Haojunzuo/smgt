package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.ElCourse;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.ElCourseService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/elCourse")
public class ElCourseController {

    @Autowired
    private ElCourseService ElCourseService;


    @GetMapping("/list")
    public TableDataInfo list(ElCourse ElCourse) {
        System.out.println(ElCourse.toString());
        Integer pageNum = ElCourse.getPageNum();
        Integer pageSize = ElCourse.getPageSize();
        String orderBy = ElCourse.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<ElCourse> list = ElCourseService.selectElCourseList(ElCourse);
        return PageUtils.getMyDataTable(list);
    }
}
