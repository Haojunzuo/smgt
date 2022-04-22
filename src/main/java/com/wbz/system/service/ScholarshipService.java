package com.wbz.system.service;

import com.wbz.system.domain.Scholarship;
import com.wbz.system.domain.StuScholarship;

import java.util.List;

public interface ScholarshipService {

    List<Scholarship> selectStuScholarshipList(StuScholarship stuScholarship);

    int delScholarship(Long id);

    int updateScholarship(StuScholarship stuScholarship);

    Scholarship getScholarship(Long id);

    int insertScholarship(StuScholarship stuScholarship);
}
