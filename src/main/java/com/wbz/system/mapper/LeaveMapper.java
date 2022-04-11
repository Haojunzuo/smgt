package com.wbz.system.mapper;

import com.wbz.system.domain.Leave;

import java.util.List;


public interface LeaveMapper {
    
    public Leave selectLeaveById(Long id);

    public List<Leave> selectLeaveList(Leave Leave);

    public int insertLeave(Leave Leave);

    public int updateLeave(Leave Leave);

    public int deleteLeaveById(Long id);

    public int deleteLeaveByIds(Long[] ids);

//    List<Leave> selectallData();

//   public List<Leave> judgeStaffCatCode(String staffCatCode);
}
