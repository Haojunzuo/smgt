package com.wbz.system.domain;

public class PartTime extends BaseEntity{

    private Long id;
    private Long studentId;
    private Long userId;
    private Long noticeId;
    private String status;
    private String file;
    private String phone;
    private String detail;

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

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", userId=" + userId +
                ", noticeId=" + noticeId +
                ", status='" + status + '\'' +
                ", file='" + file + '\'' +
                ", phone='" + phone + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
