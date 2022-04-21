package com.wbz.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.wbz.system.domain.*;
import com.wbz.system.service.ScoreService;
import com.wbz.system.utils.GeneralListener;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RequestMapping("/list")
    public TableDataInfo list(Score score){
        Integer pageNum = score.getPageNum();
        Integer pageSize = score.getPageSize();
        String orderBy = score.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<Score> list = scoreService.selectScoreList(score);
        return PageUtils.getMyDataTable(list);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Score score){
        return toAjax(scoreService.updateScore(score));
    }

    @PostMapping("/importScore")
    public AjaxResult importScore(MultipartFile file) throws Exception{
        GeneralListener<Score> generalListener = new GeneralListener<>();
        EasyExcel.read(file.getInputStream(),Score.class,generalListener).sheet().doRead();
        List<Score> scoreList = generalListener.getList();
        for (Score score : scoreList) {
            Score scoreTem = new Score();
            scoreTem.setSemester(score.getSemester());
            scoreTem.setCourseNo(score.getCourseNo());
            scoreTem.setStudentNo(score.getStudentNo());
            if (scoreService.selectScoreList(scoreTem).size()<1){
                return AjaxResult.error();
            }
        }
        for (Score score : scoreList) {
//            scs:semester courseNo studentNo
            scoreService.updateScoreByscs(score);
        }
        return AjaxResult.success();
    }

    @PostMapping("/exportScore")
    public void exportCourse(HttpServletResponse response, Score score) throws IOException {
        List<Score> list = scoreService.selectScoreList(score);
        List<Score> exportList = JSON.parseArray(JSON.toJSONString(list),Score.class);
        for (Score info : exportList) {
            System.out.println(info.toString());
        }
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String filePrefix="测试文件";
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(filePrefix, "UTF-8").replaceAll("\\+", "%20");
            //Content-disposition 的 attachment参数将文件作为附件下载
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), Score.class).sheet("模板").doWrite(exportList);
        } catch (Exception e) {
            System.out.println("下载文件失败!"+e);
        }
        System.out.println("下载数据大小为:{}");
        System.out.println(exportList.size());
    }
}
