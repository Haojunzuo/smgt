package com.wbz.system.service;

import com.wbz.system.domain.ClassInfo;

import java.util.List;

public interface ClassService {
    List<ClassInfo> selectClassList(ClassInfo classInfo);
}
