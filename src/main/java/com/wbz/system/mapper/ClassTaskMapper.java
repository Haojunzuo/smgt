package com.wbz.system.mapper;

import com.wbz.system.domain.ClassTask;
import com.wbz.system.domain.vo.QueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassTaskMapper {
    int insert(ClassTask classTask);
    int updateByPrimaryKey(ClassTask classTask);
    List<ClassTask> selectAll(QueryVO queryVO);
    int deleteByPrimaryKey(ClassTask classTask);
    List<ClassTask> selectBySemester(ClassTask classTask);
    List<String> selectByColumnName(@Param("columnName") String columnName);
}
