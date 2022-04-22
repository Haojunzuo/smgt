package com.wbz.system.service;


import com.wbz.system.domain.ElCourse;
import com.wbz.system.domain.Leave;

import java.util.List;


/**
 * 人员类别Service接口
 *
 * @author zhangyanping
 * @date 2022-01-12
 */
public interface ElCourseService {

    public List<ElCourse> selectElCourseList(ElCourse elCourse);

}
