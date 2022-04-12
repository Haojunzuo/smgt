package com.wbz.system;


import com.wbz.system.domain.CourseInfo;
import com.wbz.system.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public class CourseTest {
    @Autowired
    CourseService courseService;

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
}
