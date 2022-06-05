package com.wbz.system.service;


import com.wbz.system.domain.ElCourse;
import com.wbz.system.domain.Leave;

import java.util.List;


/**
 * 人员类别Service接口
 */
public interface ElCourseService {

    public List<ElCourse> selectElCourseList(ElCourse elCourse);

}
