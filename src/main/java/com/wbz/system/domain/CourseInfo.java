package com.wbz.system.domain;

import com.alibaba.excel.annotation.ExcelProperty;

public class CourseInfo extends BaseEntity {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("课程编号")
    private String courseno;

    @ExcelProperty("课程名称")
    private String coursename;

    @ExcelProperty("课程属性")
    private String courseattr;

    @ExcelProperty("学分")
    private Integer credit;

    @ExcelProperty("学时")
    private Integer totalhour;

    @ExcelProperty("状态")
    private String status;

    @ExcelProperty("描述")
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

    public Integer getTotalhour() {
        return totalhour;
    }

    public void setTotalhour(Integer totalhour) {
        this.totalhour = totalhour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
                ", totalhour=" + totalhour +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
