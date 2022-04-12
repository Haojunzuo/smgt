package com.wbz.system.domain;

public class CourseInfo extends BaseEntity {
    private Long id;

    private String courseno;

    private String coursename;

    private String courseattr;

    private Integer credit;

    private Integer totalHour;

    private Integer status;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourseattr() {
        return courseattr;
    }

    public void setCourseattr(String courseattr) {
        this.courseattr = courseattr;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Integer totalHour) {
        this.totalHour = totalHour;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "id=" + id +
                ", courseno='" + courseno + '\'' +
                ", coursename='" + coursename + '\'' +
                ", courseattr='" + courseattr + '\'' +
                ", credit=" + credit +
                ", totalHour=" + totalHour +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
