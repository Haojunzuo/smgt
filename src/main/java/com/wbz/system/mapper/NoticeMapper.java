package com.wbz.system.mapper;

import com.wbz.system.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> selectNoticeList(Notice notice);

    int insertNotice(Notice notice);

    int delNotice(Long[] ids);

    int updateNotice(Notice notice);

    Notice getNotice(Long id);
}
