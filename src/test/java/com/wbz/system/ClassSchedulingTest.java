package com.wbz.system;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public class ClassSchedulingTest {

    @Autowired
    CourseService courseService;

    @Test
    public void codingTimeTest() {
        ClassTask classTask = new ClassTask();
        classTask.setSemester("2015-2016-1");
        if(courseService.classScheduling(classTask)==1){
            System.out.println("成功成功");
        }else{
            System.out.println("失败失败");
        }
    }

    @Test
    public void clearCoursePlan() {
        int delete = courseService.clearCoursePlan();
        if(delete>0){
            System.out.println(delete);
            System.out.println("成功成功");
        }else{
            System.out.println("失败失败");
        }
    }
}
