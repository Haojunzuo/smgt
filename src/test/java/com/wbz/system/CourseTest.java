package com.wbz.system;


import com.wbz.system.controller.CourseController;
import com.wbz.system.domain.CourseInfo;
import com.wbz.system.mapper.CourseInfoMapper;
import com.wbz.system.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public class CourseTest {
    @Autowired
    CourseService courseService;

    @Autowired
    CourseController courseController;

    @Autowired
    CourseInfoMapper courseInfoMapper;

    @Test
    public void selectCourseInfoListTest(){
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setPageNum(1);
        courseInfo.setPageSize(10);
        List<CourseInfo> courseInfoList = courseService.selectCourseInfoList(courseInfo);
        for (CourseInfo info : courseInfoList) {
            System.out.println(info.getCoursename()+info.getCourseno());
        }
    }

    @Test
    public void insertByBatch(){
        List<CourseInfo> courseInfoList = new ArrayList<>();
        for (int i=0; i<6; i++){
            CourseInfo course = new CourseInfo();
            course.setTotalhour(i);
            course.setStatus("1");
            course.setCourseattr("1");
            course.setCourseno("1");
            course.setCoursename("1");
            course.setDescription("1");
            course.setCredit(i);
            course.setId((long) i);
            courseInfoList.add(course);
        }
        courseInfoMapper.insertCourseByBatch(courseInfoList);
    }
}
