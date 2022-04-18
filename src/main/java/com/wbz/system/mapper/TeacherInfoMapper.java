package com.wbz.system.mapper;

import com.wbz.system.domain.TeacherInfo;
import com.wbz.system.domain.vo.QueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherInfoMapper {

    List<TeacherInfo> selectAll(QueryVO queryVO);

    List<TeacherInfo> selectTeacherList(TeacherInfo teacherInfo);
}
