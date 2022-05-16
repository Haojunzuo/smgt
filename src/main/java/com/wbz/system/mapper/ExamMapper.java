package com.wbz.system.mapper;

import com.wbz.system.domain.Exam;

import java.util.List;


public interface ExamMapper {
    
    public Exam selectExamById(Long id);

    public List<Exam> selectExamList(Exam Exam);

    public int insertExam(Exam Exam);

    public int updateExam(Exam Exam);

    public int deleteExamById(Long id);

    public int deleteExamByIds(Long[] ids);

}
