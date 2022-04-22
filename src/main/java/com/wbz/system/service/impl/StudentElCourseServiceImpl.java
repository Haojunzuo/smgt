package com.wbz.system.service.impl;

import com.wbz.system.domain.StudentElCourse;
import com.wbz.system.mapper.StudentElCourseMapper;
import com.wbz.system.service.StudentElCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentElCourseServiceImpl implements StudentElCourseService
{
    @Autowired
    private StudentElCourseMapper StudentElCourseMapper;

    @Override
    public List<StudentElCourse> selectStudentElCourseByStudentNo(String studentNo)
    {
        return StudentElCourseMapper.selectStudentElCourseByStudentNo(studentNo);
    }

//    @Override
//    public List<StudentElCourse> selectStudentElCourseList(StudentElCourse StudentElCourse)
//    {
//        return StudentElCourseMapper.selectStudentElCourseList(StudentElCourse);
//    }

    @Override
    public int insertStudentElCourse(StudentElCourse StudentElCourse)
    {
//        StudentElCourse.setCreateTime(new Date());
        return StudentElCourseMapper.insertStudentElCourse(StudentElCourse);
    }

    @Override
    public int updateStudentElCourse(StudentElCourse StudentElCourse)
    {
//        StudentElCourse.setUpdateTime(new Date());
        return StudentElCourseMapper.updateStudentElCourse(StudentElCourse);
    }

    @Override
    public int deleteStudentElCourseById(StudentElCourse studentElCourse)
    {
        return StudentElCourseMapper.deleteStudentElCourseById(studentElCourse);
    }

}
