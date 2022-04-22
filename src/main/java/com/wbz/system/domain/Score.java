package com.wbz.system.domain;

import com.alibaba.excel.annotation.ExcelProperty;

public class Score extends BaseEntity{

    private Long id;
    @ExcelProperty("学期")
    private String semester;
    @ExcelProperty("课程编号")
    private String courseNo;
    @ExcelProperty("课程名称")
    private String courseName;
    @ExcelProperty("课程属性")
    private String courseAttr;
    @ExcelProperty("学号")
    private String studentNo;
    @ExcelProperty("学生姓名")
    private String studentName;
    @ExcelProperty("分数")
    private double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAttr() {
        return courseAttr;
    }

    public void setCourseAttr(String courseAttr) {
        this.courseAttr = courseAttr;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", semester='" + semester + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseAttr='" + courseAttr + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                '}';
    }
}
