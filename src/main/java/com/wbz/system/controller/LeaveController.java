package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Leave;
import com.wbz.system.domain.TableDataInfo;
import com.wbz.system.utils.PageUtils;
import com.wbz.system.service.LeaveService;
import com.wbz.system.utils.BeanUtils;
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


    @GetMapping("/list")
    public TableDataInfo list(Leave leave) {
        System.out.println(leave.toString());
        Integer pageNum = leave.getPageNum();
        Integer pageSize = leave.getPageSize();
        String orderBy = leave.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<Leave> list = LeaveService.selectLeaveList(leave);
        return PageUtils.getMyDataTable(list);
    }

//    @PostMapping("/export")
//    public void export(HttpServletResponse response, Leave Leave) throws IOException
//    {
//        List<Leave> list = LeaveService.selectLeaveList(Leave);
//        ExcelUtil<Leave> util = new ExcelUtil<Leave>(Leave.class);
//        util.exportExcel(response, list, "人员类别数据");
//    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(LeaveService.selectLeaveByStudentId(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody Leave leave) {
        return toAjax(LeaveService.insertLeave(leave));
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Leave leave) {
        System.out.println(leave.toString());
        return toAjax(LeaveService.updateLeave(leave));
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
