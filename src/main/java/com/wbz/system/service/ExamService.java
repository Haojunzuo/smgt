package com.wbz.system.service;


import com.wbz.system.domain.Exam;

import java.util.List;



public interface ExamService
{
    public Exam selectExamByStudentId(Long id);

    public List<Exam> selectExamList(Exam Exam);

    public int insertExam(Exam Exam);

    public int updateExam(Exam Exam);

    public int deleteExamByIds(Long[] ids);

    public int deleteExamById(Long id);

}
