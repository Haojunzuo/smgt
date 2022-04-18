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

    private String orgSchool;
    private String planType;
    private String stuType;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date inTime;
    private String major;
    private String length;
    private String expectedGradu;
    private String schoolStatus;
    private String status;

    private User instructor;
    private ClassInfo classInfo;
    private CollegeInfo collegeInfo;
    private String userName;
    private String nickName;
    private String email;
    private String phoneNumber;
    private String sex;
    private String detailAddress;
    private String detailResidence;


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

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getOrgSchool() {
        return orgSchool;
    }

    public void setOrgSchool(String orgSchool) {
        this.orgSchool = orgSchool;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getExpectedGradu() {
        return expectedGradu;
    }

    public void setExpectedGradu(String expectedGradu) {
        this.expectedGradu = expectedGradu;
    }

    public String getSchoolStatus() {
        return schoolStatus;
    }

    public void setSchoolStatus(String schoolStatus) {
        this.schoolStatus = schoolStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getDetailResidence() {
        return detailResidence;
    }

    public void setDetailResidence(String detailResidence) {
        this.detailResidence = detailResidence;
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
                ", orgSchool='" + orgSchool + '\'' +
                ", planType='" + planType + '\'' +
                ", stuType='" + stuType + '\'' +
                ", inTime=" + inTime +
                ", major='" + major + '\'' +
                ", length='" + length + '\'' +
                ", expectedGradu='" + expectedGradu + '\'' +
                ", schoolStatus='" + schoolStatus + '\'' +
                ", status='" + status + '\'' +
                ", instructor=" + instructor +
                ", classInfo=" + classInfo +
                ", collegeInfo=" + collegeInfo +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", detailResidence='" + detailResidence + '\'' +
                '}';
    }
}
