package com.wbz.system.mapper;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.CoursePlan;
import com.wbz.system.domain.vo.QueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoursePlanMapper {

    List<CoursePlan> selectAll(QueryVO queryVO);
    int insertCoursePlan(CoursePlan coursePlan);
    int updateCoursePlan(ClassTask classTask);
    int clearCoursePlan();

}
