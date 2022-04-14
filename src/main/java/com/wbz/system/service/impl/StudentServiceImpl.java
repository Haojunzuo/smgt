package com.wbz.system.service.impl;

import com.wbz.system.domain.Student;
import com.wbz.system.mapper.StudentMapper;
import com.wbz.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentMapper StudentMapper;

    @Override
    public Student selectStudentByUserId(Long id)
    {
        return StudentMapper.selectStudentByUserId(id);
    }

    @Override
    public List<Student> selectStudentList(Student Student)
    {
        return StudentMapper.selectStudentList(Student);
    }

    @Override
    public int insertStudent(Student Student)
    {
//        Student.setCreateTime(new Date());
        return StudentMapper.insertStudent(Student);
    }

    @Override
    public int updateStudent(Student Student)
    {
//        Student.setUpdateTime(new Date());
        return StudentMapper.updateStudent(Student);
    }

    @Override
    public int deleteStudentByIds(Long[] ids)
    {
        return StudentMapper.deleteStudentByIds(ids);
    }

    @Override
    public int deleteStudentById(Long id)
    {
        return StudentMapper.deleteStudentById(id);
    }

}
