package com.wbz.system.mapper;

import com.wbz.system.domain.WeightScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComputeMapper {
    void insertWeightByBatch(List<WeightScore> weightScoreList);

    int isExist(String semester);

    void updateWeight(WeightScore weightScore);

    List<WeightScore> selectWeightList(String semester);
}
