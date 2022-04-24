package com.wbz.system.controller;

import com.alibaba.excel.EasyExcel;
import com.wbz.system.domain.*;
import com.wbz.system.service.ComputeService;
import com.wbz.system.service.ScoreService;
import com.wbz.system.utils.GeneralListener;
import com.wbz.system.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/compute")
public class ComputeController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ComputeService computeService;

    @RequestMapping("/list")
    public TableDataInfo list(WeightScore weightScore){
        String semester = weightScore.getSemester();
        Integer pageNum = weightScore.getPageNum();
        Integer pageSize = weightScore.getPageSize();
        String orderBy = weightScore.getOrderBy();
        PageUtils.startMyPage(pageNum, pageSize, orderBy);
        List<WeightScore> list = computeService.selectWeightList(semester);
        return PageUtils.getMyDataTable(list);
    }

    @PutMapping("/weight")
    public AjaxResult weight(@RequestBody String semester){
        System.out.println("semester:"+semester);
        Score scoreQuery = new Score();
        scoreQuery.setSemester(semester);
        List<Score> scoreList = scoreService.selectScoreList(scoreQuery);
        Map<String,List<Score>> scoreMap = new HashMap<>();
        for (Score score : scoreList) {
            if (scoreMap.containsKey(score.getStudentNo())){
                scoreMap.get(score.getStudentNo()).add(score);
            }else {
                List<Score> list = new LinkedList<>();
                list.add(score);
                scoreMap.put(score.getStudentNo(),list);
            }
        }

        List<WeightScore> weightScoreList = new LinkedList<>();
        for (String studentNo : scoreMap.keySet()) {
            int totalCredit = 0;
            double totalScore = 0;
            List<Score> everyStuScore = scoreMap.get(studentNo);
            for (Score score : everyStuScore) {
                if (score.getScore()!=-1){
                    totalCredit += score.getCredit();
                    totalScore = totalScore + score.getScore()*score.getCredit();
                }
            }
            double weight = totalScore/totalCredit;
            String weight1 = new Formatter().format("%.2f", weight).toString();
            WeightScore weightScore = new WeightScore();
            weightScore.setWeightScore(Double.valueOf(weight1));
            weightScore.setStudentNo(studentNo);
            weightScore.setSemester(semester);
            weightScoreList.add(weightScore);
        }
        if (computeService.isExist(semester)>0){
            for (WeightScore weightScore : weightScoreList) {
                System.out.println("update");
                System.out.println(weightScore.toString());
                computeService.updateWeight(weightScore);
            }
        }else {
            System.out.println("insert");
            computeService.insertWeightByBatch(weightScoreList);
        }
        return AjaxResult.success();
    }

    @PostMapping("/re")
    public AjaxResult re(MultipartFile file) throws Exception{
        GeneralListener<WeightScore> generalListener = new GeneralListener<>();
        EasyExcel.read(file.getInputStream(), WeightScore.class, generalListener).sheet().doRead();
        List<WeightScore> weightScoreList = generalListener.getList();
        String semester = weightScoreList.get(0).getSemester();
        if (computeService.isExist(semester)>0){
            for (WeightScore weightScore : weightScoreList) {
                computeService.updateWeight(weightScore);
            }
        }else {
            computeService.insertWeightByBatch(weightScoreList);
        }
        return AjaxResult.success();
    }

    @PutMapping("/total")
    public AjaxResult total(@RequestBody String semester){
        System.out.println(semester);
        List<WeightScore> weightScoreList = computeService.selectWeightList(semester);
        if (weightScoreList.get(0).getWeightScore()!=null&&weightScoreList.get(0).getReScore()!=null){
            for (WeightScore weightScore : weightScoreList) {
                double total = weightScore.getWeightScore()*0.8 + weightScore.getReScore()*0.2;
                weightScore.setTotalScore(total);
                computeService.updateWeight(weightScore);
            }
        }else {
            return AjaxResult.error("请先计算加权成绩、导入综测成绩！");
        }
        return AjaxResult.success("计算最终成绩成功");
    }

}
