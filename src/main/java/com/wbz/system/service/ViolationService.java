package com.wbz.system.service;


import com.wbz.system.domain.Violation;

import java.util.List;


/**
 * 人员类别Service接口
 *
 */
public interface ViolationService
{
    public Violation selectViolationByStudentId(Long id);

    public List<Violation> selectViolationList(Violation Violation);

    public int insertViolation(Violation Violation);

    public int updateViolation(Violation Violation);

    public int deleteViolationByIds(Long[] ids);

    public int deleteViolationById(Long id);

}
