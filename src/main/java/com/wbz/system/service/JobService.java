package com.wbz.system.service;

import com.wbz.system.domain.Job;

import java.util.List;

public interface JobService {
    List<Job> selectJobList(Job job);
    int insertJob(Job job);

    String checkJob(Job job);

    int updateJob(Job job);

    Job getJob(Long id);

    int delJob(Long id);
}
