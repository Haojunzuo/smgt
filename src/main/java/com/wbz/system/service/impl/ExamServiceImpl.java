package com.wbz.system.service.impl;

import com.wbz.system.domain.Exam;
import com.wbz.system.mapper.ExamMapper;
import com.wbz.system.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService
{
    @Autowired
    private ExamMapper ExamMapper;

    @Override
    public Exam selectExamByStudentId(Long id)
    {
        return ExamMapper.selectExamById(id);
    }

    @Override
    public List<Exam> selectExamList(Exam Exam)
    {
        return ExamMapper.selectExamList(Exam);
    }

    @Override
    public int insertExam(Exam Exam)
    {
        Exam.setTime(new Date());
        return ExamMapper.insertExam(Exam);
    }

    @Override
    public int updateExam(Exam Exam)
    {
        return ExamMapper.updateExam(Exam);
    }

    @Override
    public int deleteExamByIds(Long[] ids)
    {
        return ExamMapper.deleteExamByIds(ids);
    }

    @Override
    public int deleteExamById(Long id)
    {
        return ExamMapper.deleteExamById(id);
    }

}
