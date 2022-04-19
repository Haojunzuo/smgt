package com.wbz.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Date;

public class Student extends BaseEntity{

    @ExcelProperty("id")
    private Long id;
    @ExcelProperty("学号")
    private String  studentNo;
    @ExcelProperty("备用字段")
    private Long userId;
    @ExcelProperty("辅导员id")
    private Long instructorId;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @ExcelProperty("出生年月（yyyy-MM-dd）")
    private Date birth;
    @ExcelProperty("民族")
    private Integer nation;
    @ExcelProperty("政治面貌")
    private Integer politicalStatus;
    @ExcelProperty("血型")
    private Integer bloodType;
    @ExcelProperty("婚姻状态")
    private Integer maritalStatus;
    @ExcelProperty("健康状态")
    private Integer healthStatus;
    @ExcelProperty("宗教信仰")
    private Integer religious;
    @ExcelProperty("国家")
    private String country;
    @ExcelProperty("家庭地址")
    private String address;
    @ExcelProperty("籍贯")
    private String residence;
    @ExcelProperty("身份证号")
    private String identity;
    @ExcelProperty("年级")
    private String grade;
    @ExcelProperty("学院id")
    private String collegeNo;
    @ExcelProperty("班级id")
    private String classNo;

    @ExcelProperty("原始院校")
    private String orgSchool;
    @ExcelProperty("计划类型")
    private String planType;
    @ExcelProperty("学生类型")
    private String stuType;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @ExcelProperty("入学时间（yyyy-MM-dd）")
    private Date inTime;
    @ExcelProperty("专业")
    private String major;
    @ExcelProperty("学制")
    private String length;
    @ExcelProperty("预计毕业时间（yyyy-MM-dd）")
    private String expectedGradu;
    @ExcelProperty("在校状态")
    private String schoolStatus;
    @ExcelProperty("培养状态")
    private String status;

    @ExcelIgnore
    private User instructor;
    @ExcelIgnore
    private ClassInfo classInfo;
    @ExcelIgnore
    private CollegeInfo collegeInfo;
    @ExcelProperty("学号2")
    private String userName;
    @ExcelProperty("姓名")
    private String nickName;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("电话")
    private String phoneNumber;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("详细住址")
    private String detailAddress;
    @ExcelProperty("详细籍贯")
    private String detailResidence;
    @ExcelProperty("qq号码")
    private String qq;
    @ExcelProperty("微信号码")
    private String wechat;
    @ExcelProperty("紧急联系人")
    private String contact;
    @ExcelProperty("紧急联系人电话")
    private String contactPhone;
    @ExcelIgnore
    private String avatar;


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
                ", country='" + country + '\'' +
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
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", contact='" + contact + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
