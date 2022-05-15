package com.wbz.system;

import com.wbz.system.domain.Job;
import com.wbz.system.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SystemApplication.class)
public class JobTest {
    @Autowired
    private JobService jobService;

    @Test
    public void testJobList(){
        Job job = new Job();
        job.setStudentNo("2018061302");
        List<Job> jobs = jobService.selectJobList(job);
        for (Job job1 : jobs) {
            System.out.println("job1 = " + job1);
        }
    }

    @Test
    public void testAddJob(){
        Job job = new Job();
        job.setStudentNo("2018061302");
        job.setApplyTime(new Date());
        job.setCompanyNo("3");
        job.setPostNo("4");
        job.setSalary((double) 3000);
        job.setStatus("1");
        job.setResult("未处理");
        System.out.println("jobService.insertJob(job) = " + jobService.insertJob(job));
        testJobList();
    }
}
