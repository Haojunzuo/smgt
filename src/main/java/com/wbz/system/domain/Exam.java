package com.wbz.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Exam extends BaseEntity{

    private Long id;
    private Long studentId;
    private Long checkId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String status;
    private String type;
    private String courseNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", checkId=" + checkId +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", courseNo='" + courseNo + '\'' +
                '}';
    }
}
