package com.wbz.system;

import com.wbz.system.domain.Student;
import com.wbz.system.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void selectStudentListTest(){
        Student studentQuery = new Student();
        List<Student> students = studentService.selectStudentList(studentQuery);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
