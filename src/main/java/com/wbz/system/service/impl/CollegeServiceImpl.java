package com.wbz.system.service.impl;

import com.wbz.system.domain.CollegeInfo;
import com.wbz.system.mapper.CollegeMapper;
import com.wbz.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<CollegeInfo> selectCollegeList(CollegeInfo collegeInfo) {
        return collegeMapper.selectCollegeList(collegeInfo);
    }
}
