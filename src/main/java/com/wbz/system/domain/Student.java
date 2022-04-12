package com.wbz.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student extends BaseEntity{

    private Long id;
    private String  studentNo;
    private Long userId;
    private Long instructor_id;
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


}
