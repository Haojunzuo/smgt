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


    List<ClassTask> selectClassTaskList(ClassTask classTask);

    int checkCourseExist(ClassTask classTask);

    int insertClassTask(ClassTask classTask);

    ClassTask selectClassTaskById(Long id);

    int updateClassTask(ClassTask classTask);

    int delClassTask(Long[] ids);

    void insertClassTaskByBatch(@Param("list") List<ClassTask> classTaskList);

}
