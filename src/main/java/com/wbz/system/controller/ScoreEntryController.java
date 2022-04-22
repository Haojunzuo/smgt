package com.wbz.system.controller;

import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.Score;
import com.wbz.system.service.ScoreEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoreEntry")
public class ScoreEntryController {

    @Autowired
    private ScoreEntryService scoreEntryService;


    @RequestMapping("/{semester}")
    public AjaxResult selectScoreEntryBySemester(@PathVariable("semester") String semester){
        System.out.println(scoreEntryService.isStart(semester));
        Boolean status = !"0".equals(scoreEntryService.isStart(semester));
        return AjaxResult.success(status);
    }

    @PutMapping
    public AjaxResult updateEntryStart(@RequestBody String semester){
        System.out.println(semester);
        return AjaxResult.success(scoreEntryService.updateEntryStart(semester));
    }

    @PutMapping("/insertScoreTable")
    public AjaxResult insertScoreTable(@RequestBody String semester){
        scoreEntryService.delScoreBySemester(semester);
        List<Score> scores = scoreEntryService.selectCourseBySemester(semester);
        for (Score score : scores) {
            score.setScore(-1);
        }
        int insertNumber = scoreEntryService.insertScoreByBatch(scores);
        return AjaxResult.success(insertNumber);
    }
}
