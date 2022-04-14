package com.wbz.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student extends BaseEntity{

    private Long id;
    private String  studentNo;
    private Long userId;
    private Long instructorId;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date birth;
    private Integer nation;
    private Integer politicalStatus;
    private Integer bloodType;
    private Integer maritalStatus;
    private Integer healthStatus;
    private Integer religious;
    private Integer country;
    private String address;
    private String residence;
    private String identity;
    private String grade;
    private String collegeNo;
    private String classNo;

    private User instructor;
    private ClassInfo classInfo;
    private CollegeInfo collegeInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInstructor_id() {
        return instructorId;
    }

    public void setInstructor_id(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getReligious() {
        return religious;
    }

    public void setReligious(Integer religious) {
        this.religious = religious;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCollegeNo() {
        return collegeNo;
    }

    public void setCollegeNo(String collegeNo) {
        this.collegeNo = collegeNo;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public CollegeInfo getCollegeInfo() {
        return collegeInfo;
    }

    public void setCollegeInfo(CollegeInfo collegeInfo) {
        this.collegeInfo = collegeInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", userId=" + userId +
                ", instructorId=" + instructorId +
                ", birth=" + birth +
                ", nation=" + nation +
                ", politicalStatus=" + politicalStatus +
                ", bloodType=" + bloodType +
                ", maritalStatus=" + maritalStatus +
                ", healthStatus=" + healthStatus +
                ", religious=" + religious +
                ", country=" + country +
                ", address='" + address + '\'' +
                ", residence='" + residence + '\'' +
                ", identity='" + identity + '\'' +
                ", grade='" + grade + '\'' +
                ", collegeNo='" + collegeNo + '\'' +
                ", classNo='" + classNo + '\'' +
                ", instructor=" + instructor +
                ", classInfo=" + classInfo +
                ", collegeInfo=" + collegeInfo +
                '}';
    }
}
