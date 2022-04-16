package com.wbz.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ToRequest extends BaseEntity{

    private Long id;
    private Long studentId;
    private Long userId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date requestTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toTime;
    private String toDetail;
    private String status;
    private String resultType;
    private String result;
    private Integer toType;
    private String location;
    private String imgFile;
    private String textFile;
    private String phone;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;
    private String detailLocation;
    private String toNum;

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

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public String getToDetail() {
        return toDetail;
    }

    public void setToDetail(String toDetail) {
        this.toDetail = toDetail;
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

    public Integer getToType() {
        return toType;
    }

    public void setToType(Integer toType) {
        this.toType = toType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(String detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getToNum() {
        return toNum;
    }

    public void setToNum(String toNum) {
        this.toNum = toNum;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "ToRequest{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", userId=" + userId +
                ", requestTime=" + requestTime +
                ", toTime=" + toTime +
                ", toDetail='" + toDetail + '\'' +
                ", status='" + status + '\'' +
                ", resultType='" + resultType + '\'' +
                ", result='" + result + '\'' +
                ", toType=" + toType +
                ", location='" + location + '\'' +
                ", imgFile='" + imgFile + '\'' +
                ", textFile='" + textFile + '\'' +
                ", phone='" + phone + '\'' +
                ", checkTime=" + checkTime +
                ", detailLocation='" + detailLocation + '\'' +
                ", toNum='" + toNum + '\'' +
                '}';
    }
}
