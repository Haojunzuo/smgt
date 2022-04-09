package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Leave;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService LeaveService;

//    @GetMapping("/list")
//    public TableDataInfo list(Leave Leave)
//    {
//        startPage();
//        List<Leave> list = LeaveService.selectLeaveList(Leave);
//        return getDataTable(list);
//    }

//    @PostMapping("/export")
//    public void export(HttpServletResponse response, Leave Leave) throws IOException
//    {
//        List<Leave> list = LeaveService.selectLeaveList(Leave);
//        ExcelUtil<Leave> util = new ExcelUtil<Leave>(Leave.class);
//        util.exportExcel(response, list, "人员类别数据");
//    }

    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return AjaxResult.success(LeaveService.selectLeaveByStudentId(studentId));
    }

    @PostMapping
    public AjaxResult add(@RequestBody Leave Leave) {
        return toAjax(LeaveService.insertLeave(Leave));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Leave Leave) {
        return toAjax(LeaveService.updateLeave(Leave));
    }

	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(LeaveService.deleteLeaveByIds(ids));
    }


//    @PostMapping("/importData")
//    @ResponseBody
//    public AjaxResult importData(MultipartFile file) throws Exception
//    {
//        //SupplierPriceManagement这里改为自己的实体类
//        ExcelUtil<Leave> util = new ExcelUtil<Leave>(Leave.class);
//        List<Leave> list = util.importExcel(file.getInputStream());
//        //这里调用自己的service处理导入数据
//        LeaveService.importLeave(list);
//        return AjaxResult.success();
//    }
}
