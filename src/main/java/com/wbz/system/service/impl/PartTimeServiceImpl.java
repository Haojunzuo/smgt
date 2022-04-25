package com.wbz.system.service.impl;

import com.wbz.system.domain.PartTime;
import com.wbz.system.mapper.PartTimeMapper;
import com.wbz.system.service.PartTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PartTimeServiceImpl implements PartTimeService
{
    @Autowired
    private PartTimeMapper partTimeMapper;

    @Override
    public PartTime selectPartTimeByStudentId(Long id)
    {
        return partTimeMapper.selectPartTimeById(id);
    }

    @Override
    public List<PartTime> selectPartTimeList(PartTime partTime)
    {
        return partTimeMapper.selectPartTimeList(partTime);
    }

    @Override
    public int insertPartTime(PartTime partTime)
    {
        return partTimeMapper.insertPartTime(partTime);
    }

    @Override
    public int updatePartTime(PartTime partTime)
    {
//        PartTime.setUpdateTime(new Date());
        return partTimeMapper.updatePartTime(partTime);
    }

    @Override
    public int updatePartTimeStatus(PartTime partTime) {
        return partTimeMapper.updatePartTimeStatus(partTime);
    }

    @Override
    public int deletePartTimeByIds(Long[] ids)
    {
        return partTimeMapper.deletePartTimeByIds(ids);
    }

    @Override
    public int deletePartTimeById(Long id)
    {
        return partTimeMapper.deletePartTimeById(id);
    }

}
