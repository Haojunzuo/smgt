package com.wbz.system.domain;

import java.math.BigDecimal;

public class Scholarship extends BaseEntity{
    private Integer id;
    private String semester;
    private String scholarshipNo;
    private String scholarshipName;
    private String studentNo;
    private String studentName;
    private String type;
    private BigDecimal money;
    private String reason;
    private Integer instructorId;
    private String instructorName;
    private String status;
    private String file;
    private Double totalScore;

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getScholarshipNo() {
        return scholarshipNo;
    }

    public void setScholarshipNo(String scholarshipNo) {
        this.scholarshipNo = scholarshipNo;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "id=" + id +
                ", semester='" + semester + '\'' +
                ", scholarshipNo='" + scholarshipNo + '\'' +
                ", scholarshipName='" + scholarshipName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", reason='" + reason + '\'' +
                ", instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", status='" + status + '\'' +
                ", file='" + file + '\'' +
                ", totalScore=" + totalScore +
                '}';
    }
}
