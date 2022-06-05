package com.wbz.system.service;


import com.wbz.system.domain.Leave;

import java.util.List;


/**
 * 人员类别Service接口
 *
 */
public interface LeaveService
{
    public Leave selectLeaveByStudentId(Long id);

    public List<Leave> selectLeaveList(Leave Leave);

    public int insertLeave(Leave Leave);

    public int updateLeave(Leave Leave);

    public int deleteLeaveByIds(Long[] ids);

    public int deleteLeaveById(Long id);

//    List<Leave> selectallData();

//    List<Leave> judgeStaffCatCode(String staffCatCode);

//    void importLeave(List<Leave> list);
}
