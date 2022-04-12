package com.wbz.system.mapper;

import com.wbz.system.domain.LocationInfo;
import com.wbz.system.domain.vo.QueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationInfoMapper {
    int deleteByPrimaryKey(LocationInfo locationInfo);

    int insert(LocationInfo locationInfo);

    List<LocationInfo> selectAll(QueryVO queryVO);

    int updateByPrimaryKey(LocationInfo locationInfo);

    String selectBuildNo(@Param("collegeNo") String collegeNo);
}
