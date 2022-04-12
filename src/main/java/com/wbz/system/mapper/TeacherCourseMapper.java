package com.wbz.system.mapper;

import com.wbz.system.domain.CoursePlan;
import com.wbz.system.domain.TeacherCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeacherCourse record);

    List<TeacherCourse> selectAll();

    int updateByPrimaryKey(TeacherCourse record);
    int insertTeacherCourse(CoursePlan coursePlan);
}
