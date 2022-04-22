package com.wbz.system.service.impl;

import com.wbz.system.domain.Scholarship;
import com.wbz.system.domain.StuScholarship;
import com.wbz.system.mapper.ScholarshipMapper;
import com.wbz.system.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {
    @Autowired
    private ScholarshipMapper scholarshipMapper;
    @Override
    public List<Scholarship> selectStuScholarshipList(StuScholarship stuScholarship) {
        return scholarshipMapper.selectStuScholarshipList(stuScholarship);
    }

    @Override
    public int delScholarship(Long id) {
        return scholarshipMapper.delScholarship(id);
    }

    @Override
    public int updateScholarship(StuScholarship stuScholarship) {
        return scholarshipMapper.updateScholarship(stuScholarship);
    }

    @Override
    public Scholarship getScholarship(Long id) {
        return scholarshipMapper.getScholarship(id);
    }

    @Override
    public int insertScholarship(StuScholarship stuScholarship) {
        return scholarshipMapper.insertScholarship(stuScholarship);
    }
}
