package com.wbz.system.service;


import com.wbz.system.domain.StudentElCourse;

import java.util.List;


public interface StudentElCourseService
{
    public List<StudentElCourse> selectStudentElCourseByStudentNo(String studentNo);

//    public List<StudentElCourse> selectStudentElCourseList(StudentElCourse StudentElCourse);

    public int insertStudentElCourse(StudentElCourse studentElCourse);

    public int updateStudentElCourse(StudentElCourse studentElCourse);

    public int deleteStudentElCourseById(StudentElCourse studentElCourse);
    
}
