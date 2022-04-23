package com.wbz.system.mapper;

import com.wbz.system.domain.Scholarship;
import com.wbz.system.domain.StuScholarship;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScholarshipMapper {
    List<Scholarship> selectStuScholarshipList(StuScholarship stuScholarship);

    int delScholarship(Long id);

    int updateScholarship(StuScholarship stuScholarship);

    Scholarship getScholarship(Long id);

    int insertScholarship(StuScholarship stuScholarship);

    int checkScholarshipExit(StuScholarship stuScholarship);
}
