package com.wbz.system.domain;

public class ElCourse extends BaseEntity {
    private Long id;

    private String collegeNo;

    private String courseNo;

    private String teacherNo;

    private String classroomNo;

    private String courseTime;

    private Integer weeks;

    private String semester;

    private Integer limitation;

    private Integer studentNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegeNo() {
        return collegeNo;
    }

    public void setCollegeNo(String collegeNo) {
        this.collegeNo = collegeNo;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "ElCourse{" +
                "id=" + id +
                ", collegeNo='" + collegeNo + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", classroomNo='" + classroomNo + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", weeks=" + weeks +
                ", semester='" + semester + '\'' +
                ", limitation=" + limitation +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
