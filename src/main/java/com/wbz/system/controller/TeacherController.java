package com.wbz.system.controller;

import com.wbz.system.domain.CollegeInfo;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.domain.TeacherInfo;
import com.wbz.system.service.TeacherService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/list")
    public TableDataInfo list(TeacherInfo teacherInfo){
        Integer pageNum = teacherInfo.getPageNum();
        Integer pageSize = teacherInfo.getPageSize();
        String orderBy = teacherInfo.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<TeacherInfo> teacherInfoList = teacherService.selectTeacherList(teacherInfo);
        return PageUtils.getMyDataTable(teacherInfoList);
    }

}
