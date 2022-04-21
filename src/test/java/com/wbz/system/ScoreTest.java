package com.wbz.system;


import com.wbz.system.domain.Score;
import com.wbz.system.service.ScoreEntryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SystemApplication.class)
@RunWith(SpringRunner.class)
public class ScoreTest {
    @Autowired
    private ScoreEntryService scoreEntryService;

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
}
