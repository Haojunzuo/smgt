package com.wbz.system.service.impl;

import com.wbz.system.domain.Notice;
import com.wbz.system.mapper.NoticeMapper;
import com.wbz.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> selectNoticeList(Notice notice) {
        return noticeMapper.selectNoticeList(notice);
    }

    @Override
    public int insertNotice(Notice notice) {
        return noticeMapper.insertNotice(notice);
    }

    @Override
    public int delNotice(Long[] ids) {
        return noticeMapper.delNotice(ids);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public Notice getNotice(Long id) {
        return noticeMapper.getNotice(id);
    }
}
