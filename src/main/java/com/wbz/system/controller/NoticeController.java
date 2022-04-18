package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.CourseInfo;
import com.wbz.system.domain.Notice;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.NoticeService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    public TableDataInfo list(Notice notice){
        Integer pageNum = notice.getPageNum();
        Integer pageSize = notice.getPageSize();
        String orderBy = notice.getOrderBy();
        PageUtils.startMyPage(pageNum,pageSize,orderBy);
        List<Notice> noticeList = noticeService.selectNoticeList(notice);
        return PageUtils.getMyDataTable(noticeList);
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping
    public AjaxResult add(@RequestBody Notice notice, HttpSession session){
        notice.setNoticetime(new Date());
        Long userId = (Long) session.getAttribute("userId");
        notice.setPublisher(String.valueOf(userId));
        return toAjax(noticeService.insertNotice(notice));
    }

    @DeleteMapping("/{ids}")
    public AjaxResult delNotice(@PathVariable Long[] ids){
        return toAjax(noticeService.delNotice(ids));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Notice notice){
        System.out.println(notice.toString());
        return toAjax(noticeService.updateNotice(notice));
    }

    @RequestMapping("/{id}")
    public AjaxResult getNotice(@PathVariable("id") Long id){

        return AjaxResult.success(noticeService.getNotice(id));
    }
}
