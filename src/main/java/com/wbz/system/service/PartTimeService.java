package com.wbz.system.service;


import com.wbz.system.domain.PartTime;

import java.util.List;


public interface PartTimeService
{
    public PartTime selectPartTimeByStudentId(Long id);

    public List<PartTime> selectPartTimeList(PartTime partTime);

    public int insertPartTime(PartTime partTime);

    public int updatePartTime(PartTime partTime);

    public int updatePartTimeStatus(PartTime PpartTime);

    public int deletePartTimeByIds(Long[] ids);

    public int deletePartTimeById(Long id);

}
