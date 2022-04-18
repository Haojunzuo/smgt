package com.wbz.system.service;

import com.wbz.system.domain.TeacherInfo;

import java.util.List;

public interface TeacherService {
    List<TeacherInfo> selectTeacherList(TeacherInfo teacherInfo);
}
