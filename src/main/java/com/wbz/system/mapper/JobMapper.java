package com.wbz.system.mapper;

import com.wbz.system.domain.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {
    List<Job> selectJobList(Job job);

    int insertJob(Job job);

    int checkJob(Job job);

    int updateJob(Job job);

    Job getJob(Long id);

    int delJob(Long id);
}
