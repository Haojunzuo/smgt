package com.wbz.system.service;


import com.wbz.system.domain.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreEntryService {

    String isStart(String semester);

    int updateEntryStart(String semester);

    List<Score> selectCourseBySemester(String semester);

    int insertScoreByBatch(List<Score> scoreList);

    int delScoreBySemester(String semester);
}
