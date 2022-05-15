package com.wbz.system.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class Notice extends BaseEntity {

    private Long id;

    private String noticeno;

    private String title;

//    MySQL的text对应实体类的String
    private String content;

    private String publisher;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date noticetime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:MM:SS")
    private Date endTime;

    private String noticetype;

    private String file;

    private String urgency;

    private String status;

    private String institution;

    private User user;

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", noticeno='" + noticeno + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publisher='" + publisher + '\'' +
                ", noticetime=" + noticetime +
                ", endTime=" + endTime +
                ", noticetype='" + noticetype + '\'' +
                ", file='" + file + '\'' +
                ", urgency='" + urgency + '\'' +
                ", status='" + status + '\'' +
                ", institution='" + institution + '\'' +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeno() {
        return noticeno;
    }

    public void setNoticeno(String noticeno) {
        this.noticeno = noticeno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(String noticetype) {
        this.noticetype = noticetype;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
