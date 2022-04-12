package com.wbz.system.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassInfoMapper {
    int selectStudentNumber(@Param("classNo") String classNo);
}
