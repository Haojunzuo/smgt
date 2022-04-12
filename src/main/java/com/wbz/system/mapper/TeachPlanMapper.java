package com.wbz.system.mapper;

import com.wbz.system.domain.vo.QueryVO;
import com.wbz.system.domain.vo.TeachPlanVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeachPlanMapper {

    List<TeachPlanVO> selectAll(QueryVO queryVO);


}
