package com.wbz.system.controller;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.wbz.system.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("user")
public class User {

    //生成验证码
    @GetMapping("getImage")
    public Map<String, Object> getImage(HttpSession session) throws IOException {
        System.out.println(11111111);
        Map<String,Object> map = new HashMap<String, Object>();;
        //生成验证码
        String securityCode = VerifyCodeUtils.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = VerifyCodeUtils.createImage(securityCode);
        //输出图片
//        ServletOutputStream outputStream = response.getOutputStream();
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        //调用工具类
        ImageIO.write(image,"jpg",os);
//        map.put("img", Base64.encode(os.toByteArray()));
        map.put("img", os.toByteArray());
        return map;
    }

}
