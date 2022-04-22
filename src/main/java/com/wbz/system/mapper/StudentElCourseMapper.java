package com.wbz.system.mapper;

import com.wbz.system.domain.StudentElCourse;

import java.util.List;


public interface StudentElCourseMapper {
    
    public List<StudentElCourse> selectStudentElCourseByStudentNo(String studentNo);

//    public List<StudentElCourse> selectStudentElCourseList(StudentElCourse StudentElCourse);

    public int insertStudentElCourse(StudentElCourse studentElCourse);

    public int updateStudentElCourse(StudentElCourse studentElCourse);

    public int deleteStudentElCourseById(StudentElCourse studentElCourse);

    
}
