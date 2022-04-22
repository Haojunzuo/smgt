package com.wbz.system.mapper;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.CoursePlan;
import com.wbz.system.domain.ElCourse;
import com.wbz.system.domain.vo.QueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElCourseMapper {

    List<ElCourse> selectElCourseList(ElCourse elCourse);
    public int updateElCourseById(Long id);
    public int updateElCourseByIdDel(Long id);
}
