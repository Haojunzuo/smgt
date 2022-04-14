package com.wbz.system.mapper;

import com.wbz.system.domain.Student;

import java.util.List;


public interface StudentMapper {
    
    public Student selectStudentByUserId(Long userId);

    public List<Student> selectStudentList(Student Student);

    public int insertStudent(Student Student);

    public int updateStudent(Student Student);

    public int deleteStudentById(Long id);

    public int deleteStudentByIds(Long[] ids);

}
