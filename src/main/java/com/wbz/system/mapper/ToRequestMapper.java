package com.wbz.system.mapper;

import com.wbz.system.domain.ToRequest;

import java.util.List;


public interface ToRequestMapper {
    
    public ToRequest selectToRequestById(Long id);

    public List<ToRequest> selectToRequestList(ToRequest toRequest);

    public int insertToRequest(ToRequest toRequest);

    public int updateToRequest(ToRequest toRequest);

    public int deleteToRequestById(Long id);

    public int deleteToRequestByIds(Long[] ids);

    public int updateToRequestStatus(ToRequest toRequest);
}
