package com.wbz.system.service;

import com.wbz.system.domain.Score;

import java.util.List;

public interface ScoreService {
    List<Score> selectScoreList(Score score);
    int updateScore(Score score);

    int updateScoreByscs(Score score);
}
