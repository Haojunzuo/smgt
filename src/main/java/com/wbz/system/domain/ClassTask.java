package com.wbz.system.domain;

import com.alibaba.excel.annotation.ExcelProperty;

public class ClassTask extends BaseEntity{


    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("学期")
    private String semester;

    @ExcelProperty("学院编号")
    private String collegeno;

    @ExcelProperty("班级编号")
    private String classno;

    @ExcelProperty("课程编号")
    private String courseno;

    @ExcelProperty("教师编号")
    private String teacherno;

    @ExcelProperty("课程属性")
    private String courseattr;

    @ExcelProperty("学生人数")
    private Integer studentnumber;

    @ExcelProperty("每周课时")
    private Integer weekssum;

    @ExcelProperty("总周数")
    private Integer weeksnumber;

    @ExcelProperty("固定上课时间")
    private String isfix;

    @ExcelProperty("上课时间")
    private String classtime;

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

    public String getCollegeno() {
        return collegeno;
    }

    public void setCollegeno(String collegeno) {
        this.collegeno = collegeno;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getCourseattr() {
        return courseattr;
    }

    public void setCourseattr(String courseattr) {
        this.courseattr = courseattr;
    }

    public Integer getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(Integer studentnumber) {
        this.studentnumber = studentnumber;
    }

    public Integer getWeekssum() {
        return weekssum;
    }

    public void setWeekssum(Integer weekssum) {
        this.weekssum = weekssum;
    }

    public Integer getWeeksnumber() {
        return weeksnumber;
    }

    public void setWeeksnumber(Integer weeksnumber) {
        this.weeksnumber = weeksnumber;
    }

    public String getIsfix() {
        return isfix;
    }

    public void setIsfix(String isfix) {
        this.isfix = isfix;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    @Override
    public String toString() {
        return "ClassTask{" +
                "id=" + id +
                ", semester='" + semester + '\'' +
                ", collegeno='" + collegeno + '\'' +
                ", classno='" + classno + '\'' +
                ", courseno='" + courseno + '\'' +
                ", teacherno='" + teacherno + '\'' +
                ", courseattr='" + courseattr + '\'' +
                ", studentnumber=" + studentnumber +
                ", weekssum=" + weekssum +
                ", weeksnumber=" + weeksnumber +
                ", isfix='" + isfix + '\'' +
                ", classtime='" + classtime + '\'' +
                '}';
    }
}
