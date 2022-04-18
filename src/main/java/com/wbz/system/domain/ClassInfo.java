package com.wbz.system.domain;

public class ClassInfo extends BaseEntity{
    private Long id;

    private String classno;

    private String classname;

    private Integer studentnumber;

    private String collegeno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(Integer studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getCollegeno() {
        return collegeno;
    }

    public void setCollegeno(String collegeno) {
        this.collegeno = collegeno;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id=" + id +
                ", classno='" + classno + '\'' +
                ", classname='" + classname + '\'' +
                ", studentnumber=" + studentnumber +
                ", collegeno='" + collegeno + '\'' +
                '}';
    }
}
