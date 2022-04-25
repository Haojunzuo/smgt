package com.wbz.system.service.impl;

import com.wbz.system.domain.Violation;
import com.wbz.system.mapper.ViolationMapper;
import com.wbz.system.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ViolationServiceImpl implements ViolationService
{
    @Autowired
    private ViolationMapper ViolationMapper;

    @Override
    public Violation selectViolationByStudentId(Long id)
    {
        return ViolationMapper.selectViolationById(id);
    }

    @Override
    public List<Violation> selectViolationList(Violation Violation)
    {
        return ViolationMapper.selectViolationList(Violation);
    }

    @Override
    public int insertViolation(Violation Violation)
    {
        Violation.setTime(new Date());
        return ViolationMapper.insertViolation(Violation);
    }

    @Override
    public int updateViolation(Violation Violation)
    {
        if(Violation.getStatus().equals(2)){
            Violation.setDealTime(new Date());
        }
        return ViolationMapper.updateViolation(Violation);
    }

    @Override
    public int deleteViolationByIds(Long[] ids)
    {
        return ViolationMapper.deleteViolationByIds(ids);
    }

    @Override
    public int deleteViolationById(Long id)
    {
        return ViolationMapper.deleteViolationById(id);
    }

}
