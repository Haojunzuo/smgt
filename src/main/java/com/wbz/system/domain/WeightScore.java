package com.wbz.system.domain;

import com.alibaba.excel.annotation.ExcelProperty;

public class WeightScore extends BaseEntity{
    private Integer id;
    @ExcelProperty("学号")
    private String studentNo;
    @ExcelProperty("学期")
    private String semester;
    private Double weightScore;
    @ExcelProperty("综测成绩")
    private Double reScore;
    private Double totalScore;
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Double getWeightScore() {
        return weightScore;
    }

    public void setWeightScore(Double weightScore) {
        this.weightScore = weightScore;
    }

    public Double getReScore() {
        return reScore;
    }

    public void setReScore(Double reScore) {
        this.reScore = reScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "WeightScore{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", semester='" + semester + '\'' +
                ", weightScore=" + weightScore +
                ", reScore=" + reScore +
                ", totalScore=" + totalScore +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
