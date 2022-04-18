package com.wbz.system.service.impl;

import com.wbz.system.domain.ClassInfo;
import com.wbz.system.mapper.ClassInfoMapper;
import com.wbz.system.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public List<ClassInfo> selectClassList(ClassInfo classInfo) {
        return classInfoMapper.selectClassList(classInfo);
    }
}
