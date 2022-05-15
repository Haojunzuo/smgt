package com.wbz.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Job extends BaseEntity{

    private Long id;
    private String studentNo;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")//返回时间类型
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接收时间类型
    private Date applyTime;
    private String companyNo;
    private String postNo;
    private Double salary;
    private String status;
    private String result;
    private String studentName;
    private String companyName;
    private String postName;
    private Long instructorId;
    private String reason;
    private String instructorName;
    private String imgFile;
    private String textFile;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", applyTime=" + applyTime +
                ", companyNo='" + companyNo + '\'' +
                ", postNo='" + postNo + '\'' +
                ", salary=" + salary +
                ", status='" + status + '\'' +
                ", result='" + result + '\'' +
                ", studentName='" + studentName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", postName='" + postName + '\'' +
                ", instructorId=" + instructorId +
                ", reason='" + reason + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", imgFile='" + imgFile + '\'' +
                ", textFile='" + textFile + '\'' +
                '}';
    }

    public String getimgFile() {
        return imgFile;
    }

    public void setimgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

}
