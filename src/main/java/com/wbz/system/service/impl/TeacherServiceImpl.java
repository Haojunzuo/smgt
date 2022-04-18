package com.wbz.system.service.impl;

import com.wbz.system.domain.TeacherInfo;
import com.wbz.system.mapper.TeacherInfoMapper;
import com.wbz.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Override
    public List<TeacherInfo> selectTeacherList(TeacherInfo teacherInfo) {
        return teacherInfoMapper.selectTeacherList(teacherInfo);
    }
}
