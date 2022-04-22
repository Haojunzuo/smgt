package com.wbz.system.domain;

import java.util.Set;

public class StudentElCourse extends BaseEntity {
    private Long id;

    private String StudentNo;

    private Long elCourse;

    private ElCourse elCourses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public Long getElCourse() {
        return elCourse;
    }

    public void setElCourse(Long elCourse) {
        this.elCourse = elCourse;
    }

    public ElCourse getElCourses() {
        return elCourses;
    }

    public void setElCourses(ElCourse elCourses) {
        this.elCourses = elCourses;
    }


    @Override
    public String toString() {
        return "StudentElCourse{" +
                "id=" + id +
                ", StudentNo='" + StudentNo + '\'' +
                ", elCourse='" + elCourse + '\'' +
                ", elCourses=" + elCourses +
                '}';
    }
}
