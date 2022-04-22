package com.wbz.system.service.impl;

import com.wbz.system.domain.Score;
import com.wbz.system.mapper.ScoreMapper;
import com.wbz.system.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectScoreList(Score score) {
        return scoreMapper.selectScoreList(score);
    }

    @Override
    public int updateScore(Score score) {
        return scoreMapper.updateScore(score);
    }

    @Override
    public int updateScoreByscs(Score score) {
        return scoreMapper.updateScoreByscs(score);
    }
}
