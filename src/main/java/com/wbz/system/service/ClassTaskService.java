package com.wbz.system.service;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.CoursePlan;

import java.util.List;

public interface ClassTaskService {
    List<ClassTask> selectClassTaskList(ClassTask classTask);

    String checkCourseExist(ClassTask classTask);

    int insertClassTask(ClassTask classTask);

    ClassTask selectClassTaskById(Long id);

    int updateClassTask(ClassTask classTask);

    List<CoursePlan> selectCoursePlanList(CoursePlan coursePlan);

    int delClassTask(Long[] ids);

    void insertClassTaskByBatch(List<ClassTask> classTaskList);
}
