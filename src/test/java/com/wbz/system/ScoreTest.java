package com.wbz.system;


import com.wbz.system.domain.Score;
import com.wbz.system.domain.WeightScore;
import com.wbz.system.service.ComputeService;
import com.wbz.system.service.ScoreEntryService;
import com.wbz.system.service.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest(classes = SystemApplication.class)
@RunWith(SpringRunner.class)
public class ScoreTest {
    @Autowired
    private ScoreEntryService scoreEntryService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ComputeService computeService;

    @Test
    public void testScoreEntry(){
        System.out.println(scoreEntryService.isStart("2015-2016-1"));
    }

    @Test
    public void testUpdateEntry(){
        System.out.println(scoreEntryService.updateEntryStart("2015-2016-1"));
    }

    @Test
    public void insertScoreTable(){
        List<Score> scores = scoreEntryService.selectCourseBySemester("2015-2016-1");
        for (Score score : scores) {
            score.setScore(-1);
        }
        int i = scoreEntryService.insertScoreByBatch(scores);
        System.out.println(i);
    }

    @Test
    public void  delScoreBySemester(){
        int i = scoreEntryService.delScoreBySemester("2015-2016-1");
        System.out.println(i);
    }

    @Test
    public void  scoreList(){
        Score scoreQuery = new Score();
        String semester = "2015-2016-1";
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
        computeService.insertWeightByBatch(weightScoreList);
    }
    @Test
    public void isExist(){
        System.out.println("computeService.isExist(\"2015-2016-1\") = " + computeService.isExist("2015-2016-1"));
        System.out.println("computeService.isExist(\"2016-2017-1\") = " + computeService.isExist("2016-2017-1"));
    }

    @Test
    public void selectWeightList(){
        List<WeightScore> weightScoreList = computeService.selectWeightList("2015-2016-1");
        for (WeightScore weightScore : weightScoreList) {
            System.out.println(weightScore);
        }
    }


}
