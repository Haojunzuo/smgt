package com.wbz.system.mapper;

//import com.wbz.system.domain.ClassroomLocation;
import com.wbz.system.domain.ClassroomLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

public interface ClassroomLocationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClassroomLocation record);

    ClassroomLocation selectByPrimaryKey(Long id);

    List<ClassroomLocation> selectAll();

    int updateByPrimaryKey(ClassroomLocation record);

    List<ClassroomLocation> selectByTeachBuildNo(@Param("teachBuildNo") String teachBuildNo);
}
