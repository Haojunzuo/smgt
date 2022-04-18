package com.wbz.system.mapper;


import com.wbz.system.domain.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassInfoMapper {
    int selectStudentNumber(@Param("classNo") String classNo);

    List<ClassInfo> selectClassList(ClassInfo classInfo);
}
