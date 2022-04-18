package com.wbz.system.controller;

import com.wbz.system.domain.ClassInfo;
import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.ClassService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("/list")
    public TableDataInfo list(ClassInfo classInfo){
        Integer pageNum = classInfo.getPageNum();
        Integer pageSize = classInfo.getPageSize();
        String orderBy = classInfo.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<ClassInfo> classInfoList = classService.selectClassList(classInfo);
        return PageUtils.getMyDataTable(classInfoList);
    }
}
