package com.wbz.system.mapper;

import com.wbz.system.domain.TeachBuildInfo;
import com.wbz.system.domain.vo.QueryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TeachBuildInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachBuildInfo record);

    TeachBuildInfo selectByPrimaryKey(Long id);

    List<TeachBuildInfo> selectAll(QueryVO queryVO);

    int updateByPrimaryKey(TeachBuildInfo record);
}
