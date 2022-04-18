package com.wbz.system.service.impl;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.CoursePlan;
import com.wbz.system.mapper.ClassTaskMapper;
import com.wbz.system.mapper.CoursePlanMapper;
import com.wbz.system.service.ClassTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTaskServiceImpl implements ClassTaskService {

    @Autowired
    private ClassTaskMapper classTaskMapper;
    @Autowired
    private CoursePlanMapper coursePlanMapper;

    @Override
    public List<ClassTask> selectClassTaskList(ClassTask classTask) {
        return classTaskMapper.selectClassTaskList(classTask);
    }

    @Override
    public String checkCourseExist(ClassTask classTask) {
        int size = classTaskMapper.checkCourseExist(classTask);
//        System.out.println(classTask.toString());
//        System.out.println("size:");
//        System.out.println(size);
        return size>0? "false" : "true";
    }

    @Override
    public int insertClassTask(ClassTask classTask) {
        System.out.println("classTaskServiceImpl");
        System.out.println(classTask.toString());
        return classTaskMapper.insertClassTask(classTask);
    }

    @Override
    public ClassTask selectClassTaskById(Long id) {
        return classTaskMapper.selectClassTaskById(id);
    }

    @Override
    public int updateClassTask(ClassTask classTask) {
        return classTaskMapper.updateClassTask(classTask);
    }

    @Override
    public List<CoursePlan> selectCoursePlanList(CoursePlan coursePlan) {
        return coursePlanMapper.selectCoursePlanList(coursePlan);
    }

    @Override
    public int delClassTask(Long[] ids) {
        return classTaskMapper.delClassTask(ids);
    }

    @Override
    public void insertClassTaskByBatch(List<ClassTask> classTaskList) {
        classTaskMapper.insertClassTaskByBatch(classTaskList);
    }
}
