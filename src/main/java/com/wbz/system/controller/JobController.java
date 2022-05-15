package com.wbz.system.controller;


import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Job;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.JobService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/list")
    public TableDataInfo list(Job job){
        Integer pageNum = job.getPageNum();
        Integer pageSize = job.getPageSize();
        String orderBy = job.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<Job> jobs = jobService.selectJobList(job);
        return PageUtils.getMyDataTable(jobs);
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }


    @PostMapping
    public AjaxResult add(@RequestBody  Job job){
        job.setApplyTime(new Date());
        return toAjax(jobService.insertJob(job));
    }
    @PutMapping
    public AjaxResult edit(@RequestBody Job job){
        System.out.println("job = " + job);
        return toAjax(jobService.updateJob(job));
    }

    @PutMapping("/check")
    public String checkJob(Job job){
        return jobService.checkJob(job);
    }
    @GetMapping("/{id}")
    public AjaxResult getJob(@PathVariable("id") Long id){
        return AjaxResult.success(jobService.getJob(id));
    }

    @DeleteMapping("/{id}")
    public AjaxResult delJob(@PathVariable("id") Long id){
        return toAjax(jobService.delJob(id));

    }


}
