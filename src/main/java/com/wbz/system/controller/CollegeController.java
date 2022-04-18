package com.wbz.system.controller;

import com.wbz.system.domain.CollegeInfo;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.CollegeService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @RequestMapping("/list")
    public TableDataInfo list(CollegeInfo collegeInfo){
        Integer pageNum = collegeInfo.getPageNum();
        Integer pageSize = collegeInfo.getPageSize();
        String orderBy = collegeInfo.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<CollegeInfo> collegeInfoList = collegeService.selectCollegeList(collegeInfo);
        return PageUtils.getMyDataTable(collegeInfoList);
    }
}
