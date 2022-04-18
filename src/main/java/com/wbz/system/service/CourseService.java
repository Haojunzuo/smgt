package com.wbz.system.service;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.ClassroomLocation;
import com.wbz.system.domain.CourseInfo;

import java.util.List;
import java.util.Map;

public interface CourseService {
    int classScheduling(ClassTask classTask);
    Map<String, List<String>> transformIndividual(List<String> resultGeneList);
    Map<String, List<String>> geneticEvolution(Map<String, List<String>> individualMap);
    List<String> finalResult(Map<String,List<String>> individualMap);
    String assignClassroom(String gene, List<ClassroomLocation> classroomLocationList, List<String> resultList);

    int clearCoursePlan();
    List<CourseInfo> selectCourseInfoList(CourseInfo CourseInfo);
    int insertCourse(CourseInfo courseInfo);

    int updateCourse(CourseInfo courseInfo);

    String checkno(String courseno, CourseInfo courseInfo);

    CourseInfo selectCourseById(Long id);

    int delCourse(Long[] ids);
    void insertCourseByBatch(List<CourseInfo> list);
}
