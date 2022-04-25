package com.wbz.system.mapper;

import com.wbz.system.domain.PartTime;

import java.util.List;


public interface PartTimeMapper {
    
    public PartTime selectPartTimeById(Long id);

    public List<PartTime> selectPartTimeList(PartTime partTime);

    public int insertPartTime(PartTime partTime);

    public int updatePartTime(PartTime partTime);

    public int deletePartTimeById(Long id);

    public int deletePartTimeByIds(Long[] ids);

    public int updatePartTimeStatus(PartTime partTime);
}
