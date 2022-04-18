package com.wbz.system.service;

import com.wbz.system.domain.CollegeInfo;

import java.util.List;

public interface CollegeService {
    List<CollegeInfo> selectCollegeList(CollegeInfo collegeInfo);
}
