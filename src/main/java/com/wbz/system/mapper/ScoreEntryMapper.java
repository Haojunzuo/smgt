package com.wbz.system.mapper;

import com.wbz.system.domain.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreEntryMapper {
    String isStart(String semester);

    int updateEntryStart(String semester);

    List<Score> selectCourseBySemester(String semester);

    int insertScoreByBatch(@Param("list") List<Score> scoreList);

    int delScoreBySemester(String semester);
}
