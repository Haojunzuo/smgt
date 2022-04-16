package com.wbz.system.service;


import com.wbz.system.domain.ToRequest;

import java.util.List;



public interface ToRequestService
{
    public ToRequest selectToRequestByStudentId(Long id);

    public List<ToRequest> selectToRequestList(ToRequest toRequest);

    public int insertToRequest(ToRequest toRequest);

    public int updateToRequest(ToRequest toRequest);

    public int updateToRequestStatus(ToRequest toRequest);

    public int deleteToRequestByIds(Long[] ids);

    public int deleteToRequestById(Long id);

}
