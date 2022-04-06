package com.wbz.system.mapper;


import com.wbz.system.domain.LoginBody;
import com.wbz.system.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表 数据层
 */
@Mapper
public interface UserMapper
{
    /**
     * 根据用户名密码角色查询用户
     *
     */
    public List<User> selectUserByUserNamePassWordRole(LoginBody loginBody);

}
