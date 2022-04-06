package com.wbz.system.service;

import com.wbz.system.domain.LoginBody;
import com.wbz.system.domain.User;
import com.wbz.system.mapper.UserMapper;
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
            session.setAttribute("userInfo",users.get(0));
            map.put("msg","登录成功");
        }else {
            map.put("msg","用户/密码错误");
        }
        return map;
    }
}
