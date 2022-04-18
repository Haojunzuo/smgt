package com.wbz.system.service;

import com.wbz.system.domain.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> selectNoticeList(Notice notice);

    int insertNotice(Notice notice);

    int delNotice(Long[] ids);

    int updateNotice(Notice notice);

    Notice getNotice(Long id);
}
