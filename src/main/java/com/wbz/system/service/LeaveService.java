package com.wbz.system.service;


import com.wbz.system.domain.Leave;

import java.util.List;


/**
 * 人员类别Service接口
 *
 * @author zhangyanping
 * @date 2022-01-12
 */
public interface LeaveService
{
    public Leave selectLeaveByStudentId(Long studentId);

    public List<Leave> selectLeaveList(Leave Leave);

    public int insertLeave(Leave Leave);

    public int updateLeave(Leave Leave);

    public int deleteLeaveByIds(Long[] ids);

    public int deleteLeaveById(Long id);

//    List<Leave> selectallData();

//    List<Leave> judgeStaffCatCode(String staffCatCode);

//    void importLeave(List<Leave> list);
}
