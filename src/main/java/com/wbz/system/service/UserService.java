package com.wbz.system.service;

import com.wbz.system.domain.LoginBody;
import com.wbz.system.domain.User;
import com.wbz.system.mapper.UserMapper;
import com.wbz.system.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 登录
     */
    public Map login(LoginBody form, HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        String code = String.valueOf(session.getAttribute("code"));
        System.out.println(code);
        // 验证码 错误
        if (!form.getCode().equals(code)) {
            map.put("msg","验证码错误");
            return map;
        }
        // 用户名或密码为空 错误
        if (form.getUserName().equals("") || form.getPassword().equals("")) {
            map.put("msg","用户/密码必须填写");
            return map;
        }
        List<User> users = userMapper.selectUserByUserNamePassWordRole(form);

        if(users.size()>=1){
            map.put("token", UUID.randomUUID().toString());
            session.setAttribute("userId",users.get(0).getUserId());
            map.put("msg","登录成功");
        }else {
            map.put("msg","用户/密码错误");
        }
        return map;
    }

    public User getUserByUserId(Long userId) {return userMapper.selectUserByUserId(userId);}

    public String checkPhoneUnique(User user) {
        Long userId = BeanUtils.isEmpty(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkPhoneUnique(user.getPhoneNumber());
        if (BeanUtils.isNotEmpty(info) && info.getUserId().longValue() != userId.longValue())
        {
            return "NOT_UNIQUE";
        }
        return "UNIQUE";
    }

    public String checkEmailUnique(User user) {
        Long userId = BeanUtils.isEmpty(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkEmailUnique(user.getEmail());
        if (BeanUtils.isNotEmpty(info) && info.getUserId().longValue() != userId.longValue())
        {
            return "NOT_UNIQUE";
        }
        return "UNIQUE";
    }

    public int insertUser(User user) {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        return rows;
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public boolean updateUserAvatar(Long userId, String avatar) {
        return userMapper.updateUserAvatar(userId, avatar) > 0;
    }

    public int resetUserPwd(Long userId, String password)
    {
        return userMapper.resetUserPwd(userId, password);
    }

    public int deleteUserById(Long userId) {
        return userMapper.deleteUserById(userId);
    }

    public int deleteUserByIds(Long[] userIds) {
        return userMapper.deleteUserByIds(userIds);
    }
}
