package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.ToRequest;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.ToRequestService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/toRequest")
public class ToRequestController {

    @Autowired
    private ToRequestService toRequestService;


    @GetMapping("/list")
    public TableDataInfo list(ToRequest toRequest) {
        System.out.println(toRequest.toString());
        Integer pageNum = toRequest.getPageNum();
        Integer pageSize = toRequest.getPageSize();
        String orderBy = toRequest.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<ToRequest> list = toRequestService.selectToRequestList(toRequest);
        return PageUtils.getMyDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(toRequestService.selectToRequestByStudentId(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody ToRequest toRequest) {
        return toAjax(toRequestService.insertToRequest(toRequest));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody ToRequest toRequest) {
        System.out.println(toRequest.toString());
        return toAjax(toRequestService.updateToRequest(toRequest));
    }

	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(toRequestService.deleteToRequestByIds(ids));
    }

    @PutMapping("/{id}/{status}")
    public AjaxResult editStatus(@PathVariable("id") Long id,@PathVariable("status") String status) {
        ToRequest toRequest = new ToRequest();
        toRequest.setId(id);
        toRequest.setStatus(status);
        return toAjax(toRequestService.updateToRequestStatus(toRequest));
    }

}
