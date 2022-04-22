package com.wbz.system.service.impl;

import com.wbz.system.domain.ElCourse;
import com.wbz.system.domain.Leave;
import com.wbz.system.mapper.ElCourseMapper;
import com.wbz.system.mapper.LeaveMapper;
import com.wbz.system.service.ElCourseService;
import com.wbz.system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElCourseServiceImpl implements ElCourseService
{
    @Autowired
    private ElCourseMapper elCourseMapper;


    @Override
    public List<ElCourse> selectElCourseList(ElCourse elCourse) {
        return elCourseMapper.selectElCourseList(elCourse);
    }
}
