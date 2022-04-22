package com.wbz.system.mapper;

import com.wbz.system.domain.Score;
import com.wbz.system.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreMapper {
    List<Score> selectScoreList(Score score);
    int insertScore(Score score);
    int updateScore(Score score);
    Score getScore(Long id);
    int delScore(Long[] ids);
    void insertScoreByBatch(@Param("list") List<Score> scoreList);

    int updateScoreByscs(Score score);
}
