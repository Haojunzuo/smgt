package com.wbz.system.service;


import com.wbz.system.domain.Student;

import java.util.List;


/**
 * 人员类别Service接口
 *
 * @author zhangyanping
 * @date 2022-01-12
 */
public interface StudentService {
    public Student selectStudentByUserId(Long id);

    public List<Student> selectStudentList(Student Student);

    public int insertStudent(Student Student);

    public int updateStudent(Student Student);

    public int deleteStudentByIds(Long[] ids);

    public int deleteStudentById(Long id);

//    List<Student> selectallData();

//    List<Student> judgeStaffCatCode(String staffCatCode);

//    void importStudent(List<Student> list);
}
