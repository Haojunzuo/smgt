package com.wbz.system.mapper;

import com.wbz.system.domain.CourseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseInfo record);

    CourseInfo selectByPrimaryKey(Long id);

    List<CourseInfo> selectCourseInfoList(CourseInfo courseInfo);

    int updateByPrimaryKey(CourseInfo record);

}
