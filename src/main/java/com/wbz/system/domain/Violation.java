package com.wbz.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Violation extends BaseEntity{

    private Long id;
    private Long studentId;
    private Long userId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealTime;
    private String description;
    private Integer status;
    private Integer type;
    private Integer result;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", userId=" + userId +
                ", time=" + time +
                ", dealTime=" + dealTime +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", result=" + result +
                '}';
    }
}
