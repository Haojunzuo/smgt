package com.wbz.system.mapper;

import com.wbz.system.domain.CourseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseInfo record);

    CourseInfo selectByPrimaryKey(Long id);

    List<CourseInfo> selectCourseInfoList(CourseInfo courseInfo);

    int updateByPrimaryKey(CourseInfo record);

    int insertCourse(CourseInfo courseInfo);

    int updateCourse(CourseInfo courseInfo);

    int checkno(@Param("courseno") String courseno, @Param("id") Long id);

    CourseInfo selectCourseById(Long id);

    int delCourse(Long [] ids);

    void insertCourseByBatch(@Param("list") List<CourseInfo> list);
}
