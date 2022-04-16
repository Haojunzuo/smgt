package com.wbz.system.service.impl;

import com.wbz.system.domain.ToRequest;
import com.wbz.system.mapper.ToRequestMapper;
import com.wbz.system.service.ToRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ToRequestServiceImpl implements ToRequestService
{
    @Autowired
    private ToRequestMapper ToRequestMapper;

    @Override
    public ToRequest selectToRequestByStudentId(Long id)
    {
        return ToRequestMapper.selectToRequestById(id);
    }

    @Override
    public List<ToRequest> selectToRequestList(ToRequest toRequest)
    {
        return ToRequestMapper.selectToRequestList(toRequest);
    }

    @Override
    public int insertToRequest(ToRequest toRequest)
    {
        toRequest.setRequestTime(new Date());
        return ToRequestMapper.insertToRequest(toRequest);
    }

    @Override
    public int updateToRequest(ToRequest toRequest)
    {
//        ToRequest.setUpdateTime(new Date());
        return ToRequestMapper.updateToRequest(toRequest);
    }

    @Override
    public int updateToRequestStatus(ToRequest toRequest) {
        return ToRequestMapper.updateToRequestStatus(toRequest);
    }

    @Override
    public int deleteToRequestByIds(Long[] ids)
    {
        return ToRequestMapper.deleteToRequestByIds(ids);
    }

    @Override
    public int deleteToRequestById(Long id)
    {
        return ToRequestMapper.deleteToRequestById(id);
    }

}
