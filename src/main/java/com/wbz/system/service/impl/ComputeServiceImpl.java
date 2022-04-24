package com.wbz.system.service.impl;

import com.wbz.system.domain.WeightScore;
import com.wbz.system.mapper.ComputeMapper;
import com.wbz.system.service.ComputeService;
import com.wbz.system.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputeServiceImpl implements ComputeService {
    @Autowired
    private ComputeMapper computeMapper;


    @Override
    public void insertWeightByBatch(List<WeightScore> weightScoreList) {
        computeMapper.insertWeightByBatch(weightScoreList);
    }

    @Override
    public int isExist(String semester) {
        return computeMapper.isExist(semester);
    }

    @Override
    public void updateWeight(WeightScore weightScore) {
        computeMapper.updateWeight(weightScore);
    }

    @Override
    public List<WeightScore> selectWeightList(String semester) {
        return computeMapper.selectWeightList(semester);
    }
}
