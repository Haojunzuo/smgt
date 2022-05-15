package com.wbz.system;

import com.wbz.system.domain.Notice;
import com.wbz.system.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemApplication.class)
public class NoticeTest {

    @Autowired
    private NoticeService noticeService;

    @Test
    public void testListNotice(){
        Notice notice = new Notice();
        List<Notice> noticeList = noticeService.selectNoticeList(notice);
        for (Notice notice1 : noticeList) {
            System.out.println("notice1 = " + notice1);
        }
    }
}
