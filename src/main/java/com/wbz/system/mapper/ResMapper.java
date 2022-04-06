package com.wbz.system.mapper;

import com.wbz.system.domain.Res;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResMapper {
    public List<Res> selectMenuTreeByRole(Integer role);
}
