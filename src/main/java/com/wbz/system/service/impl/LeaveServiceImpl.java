package com.wbz.system.service.impl;

import com.wbz.system.domain.Leave;
import com.wbz.system.mapper.LeaveMapper;
import com.wbz.system.service.LeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService
{
    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public Leave selectLeaveByStudentId(Long id)
    {
        return leaveMapper.selectLeaveById(id);
    }

    @Override
    public List<Leave> selectLeaveList(Leave Leave)
    {
        return leaveMapper.selectLeaveList(Leave);
    }

    @Override
    public int insertLeave(Leave Leave)
    {
//        Leave.setCreateTime(new Date());
        return leaveMapper.insertLeave(Leave);
    }

    @Override
    public int updateLeave(Leave Leave)
    {
//        Leave.setUpdateTime(new Date());
        return leaveMapper.updateLeave(Leave);
    }

    @Override
    public int deleteLeaveByIds(Long[] ids)
    {
        return leaveMapper.deleteLeaveByIds(ids);
    }

    @Override
    public int deleteLeaveById(Long id)
    {
        return leaveMapper.deleteLeaveById(id);
    }

//    /**
//     * 查询全部数据集合
//     */
//    @Override
//    public List<Leave> selectallData(){
//        return LeaveMapper.selectallData();
//    }
//
//    @Override
//    public List<Leave> judgeStaffCatCode(String staffCatCode) {
//        return LeaveMapper.judgeStaffCatCode(staffCatCode);
//    }
//
//    @Override
//    public void importLeave(List<Leave> list) {
//        for(Leave Leave:list){
//            LeaveMapper.insertLeave(Leave);
//        }
//    }
}
