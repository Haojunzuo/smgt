package com.wbz.system.domain;

public class StuScholarship extends BaseEntity{
    private Integer id;
    private String semester;
    private String studentNo;
    private String reason;
    private String scholarshipNo;
    private Integer instructorId;
    private String status;
    private String file;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getScholarshipNo() {
        return scholarshipNo;
    }

    public void setScholarshipNo(String scholarshipNo) {
        this.scholarshipNo = scholarshipNo;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "StuScholarship{" +
                "id=" + id +
                ", semester='" + semester + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", reason='" + reason + '\'' +
                ", scholarshipNo='" + scholarshipNo + '\'' +
                ", instructorId=" + instructorId +
                ", status='" + status + '\'' +
                ", file='" + file + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
