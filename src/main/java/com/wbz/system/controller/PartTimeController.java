package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.domain.PartTime;
import com.wbz.system.service.PartTimeService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/partTime")
public class PartTimeController {

    @Autowired
    private PartTimeService PartTimeService;


    @GetMapping("/list")
    public TableDataInfo list(PartTime PartTime) {
        System.out.println(PartTime.toString());
        Integer pageNum = PartTime.getPageNum();
        Integer pageSize = PartTime.getPageSize();
        String orderBy = PartTime.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<PartTime> list = PartTimeService.selectPartTimeList(PartTime);
        return PageUtils.getMyDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(PartTimeService.selectPartTimeByStudentId(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody PartTime PartTime) {
        return toAjax(PartTimeService.insertPartTime(PartTime));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody PartTime PartTime) {
        System.out.println(PartTime.toString());
        return toAjax(PartTimeService.updatePartTime(PartTime));
    }

	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(PartTimeService.deletePartTimeByIds(ids));
    }

    @PutMapping("/{id}/{status}")
    public AjaxResult editStatus(@PathVariable("id") Long id,@PathVariable("status") String status) {
        PartTime PartTime = new PartTime();
        PartTime.setId(id);
        PartTime.setStatus(status);
        return toAjax(PartTimeService.updatePartTimeStatus(PartTime));
    }

}
