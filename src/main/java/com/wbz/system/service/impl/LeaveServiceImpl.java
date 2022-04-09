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
    private LeaveMapper LeaveMapper;

    @Override
    public Leave selectLeaveByStudentId(Long studentId)
    {
        return LeaveMapper.selectLeaveByStudentId(studentId);
    }

    @Override
    public List<Leave> selectLeaveList(Leave Leave)
    {
        return LeaveMapper.selectLeaveList(Leave);
    }

    @Override
    public int insertLeave(Leave Leave)
    {
//        Leave.setCreateTime(new Date());
        return LeaveMapper.insertLeave(Leave);
    }

    @Override
    public int updateLeave(Leave Leave)
    {
//        Leave.setUpdateTime(new Date());
        return LeaveMapper.updateLeave(Leave);
    }

    @Override
    public int deleteLeaveByIds(Long[] ids)
    {
        return LeaveMapper.deleteLeaveByIds(ids);
    }

    @Override
    public int deleteLeaveById(Long id)
    {
        return LeaveMapper.deleteLeaveById(id);
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
