package com.wbz.system;


import com.wbz.system.domain.Scholarship;
import com.wbz.system.domain.StuScholarship;
import com.wbz.system.service.ScholarshipService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SystemApplication.class)
@RunWith(SpringRunner.class)
public class ScholarshipTest {
    @Autowired
    private ScholarshipService scholarshipService;

    @Test
    public void listTestScholarship(){
        StuScholarship stuScholarship = new StuScholarship();
        stuScholarship.setSemester("2015-2016-1");
        stuScholarship.setStudentNo("1");
//        stuScholarship.setType("02");
        System.out.println(stuScholarship);
        List<Scholarship> scholarships = scholarshipService.selectStuScholarshipList(stuScholarship);
        for (Scholarship scholarship : scholarships) {
            System.out.println(scholarship);
        }
    }

}
