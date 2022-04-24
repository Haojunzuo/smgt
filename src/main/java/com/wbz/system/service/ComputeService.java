package com.wbz.system.service;

import com.wbz.system.domain.WeightScore;

import java.util.List;

public interface ComputeService {
    public void insertWeightByBatch(List<WeightScore> weightScoreList);
    public int isExist(String semester);

    void updateWeight(WeightScore weightScore);

    List<WeightScore> selectWeightList(String semester);
}
