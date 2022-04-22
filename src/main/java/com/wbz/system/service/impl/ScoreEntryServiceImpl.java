package com.wbz.system.service.impl;

import com.wbz.system.domain.Score;
import com.wbz.system.mapper.ScoreEntryMapper;
import com.wbz.system.service.ScoreEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreEntryServiceImpl implements ScoreEntryService {
    @Autowired
    private ScoreEntryMapper scoreEntryMapper;

    @Override
    public String isStart(String semester){
        return scoreEntryMapper.isStart(semester);
    }

    @Override
    public int updateEntryStart(String semester) {
        return scoreEntryMapper.updateEntryStart(semester);
    }

    @Override
    public List<Score> selectCourseBySemester(String semester) {
        return scoreEntryMapper.selectCourseBySemester(semester);
    }

    @Override
    public int insertScoreByBatch(List<Score> scoreList) {
        return scoreEntryMapper.insertScoreByBatch(scoreList);
    }

    @Override
    public int delScoreBySemester(String semester) {
        return scoreEntryMapper.delScoreBySemester(semester);
    }
}
