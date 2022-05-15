package com.wbz.system.service.impl;

import com.wbz.system.domain.Job;
import com.wbz.system.mapper.JobMapper;
import com.wbz.system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<Job> selectJobList(Job job) {
        return jobMapper.selectJobList(job);
    }

    @Override
    public int insertJob(Job job) {
        return jobMapper.insertJob(job);
    }

    @Override
    public String checkJob(Job job) {
        int size = jobMapper.checkJob(job);
        return size>0?"false":"true";
    }

    @Override
    public int updateJob(Job job) {
        return jobMapper.updateJob(job);
    }

    @Override
    public Job getJob(Long id) {
        return jobMapper.getJob(id);
    }

    @Override
    public int delJob(Long id) {
        return jobMapper.delJob(id);
    }
}
