package com.wbz.system.mapper;

import com.wbz.system.domain.Violation;

import java.util.List;


public interface ViolationMapper {
    
    public Violation selectViolationById(Long id);

    public List<Violation> selectViolationList(Violation Violation);

    public int insertViolation(Violation Violation);

    public int updateViolation(Violation Violation);

    public int deleteViolationById(Long id);

    public int deleteViolationByIds(Long[] ids);

}
