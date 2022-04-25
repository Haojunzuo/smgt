package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Violation;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.ViolationService;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/violation")
public class ViolationController {

    @Autowired
    private ViolationService ViolationService;


    @GetMapping("/list")
    public TableDataInfo list(Violation Violation) {
        System.out.println(Violation.toString());
        Integer pageNum = Violation.getPageNum();
        Integer pageSize = Violation.getPageSize();
        String orderBy = Violation.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<Violation> list = ViolationService.selectViolationList(Violation);
        return PageUtils.getMyDataTable(list);
    }


    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ViolationService.selectViolationByStudentId(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody Violation Violation) {
        return toAjax(ViolationService.insertViolation(Violation));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Violation Violation) {
        System.out.println(Violation.toString());
        return toAjax(ViolationService.updateViolation(Violation));
    }

	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(ViolationService.deleteViolationByIds(ids));
    }


}
