package com.wbz.system.controller;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.wbz.system.domain.LoginBody;
import com.wbz.system.domain.Res;
import com.wbz.system.domain.User;
import com.wbz.system.domain.vo.RouterVo;
import com.wbz.system.service.ResService;
import com.wbz.system.service.UserService;
import com.wbz.system.utils.VerifyCodeUtils;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResService resService;

    //生成验证码
    @GetMapping("getImage")
    public Map<String, Object> getImage(HttpSession session) throws IOException {
        Map<String,Object> map = new HashMap<String, Object>();
        //生成验证码
        String securityCode = VerifyCodeUtils.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = VerifyCodeUtils.createImage(securityCode);
        //输出图片
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        //调用工具类
        ImageIO.write(image,"jpg",os);
//        map.put("img", Base64.encode(os.toByteArray()));
        map.put("img", os.toByteArray());
        return map;
    }

    @PostMapping("login")
    public Map login(@RequestBody LoginBody form, HttpSession session) {
        return userService.login(form,session);
    }

    @DeleteMapping("logout")
    public void logout(HttpSession session) {

    }

    @GetMapping(value = { "/getInfo", "/{userId}" })
    public Map getInfo(@PathVariable(value = "userId", required = false) Long userId,HttpSession session) {
        User user = (User) session.getAttribute("userInfo");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("user",user);
        return map;
    }
    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters/{role}")
    public List<RouterVo> getRouters(@PathVariable(value = "role") Integer role) {
        List<Res> menus = resService.selectMenuTreeByUserId(role);
        return resService.buildMenus(menus);
    }



}
