package com.wbz.system.controller;

import com.github.pagehelper.util.StringUtil;
import com.wbz.system.domain.AjaxResult;
import com.wbz.system.domain.LoginBody;
import com.wbz.system.domain.Res;
import com.wbz.system.domain.User;
import com.wbz.system.domain.vo.RouterVo;
import com.wbz.system.service.ResService;
import com.wbz.system.service.UserService;
import com.wbz.system.utils.SecurityUtils;
import com.wbz.system.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
        session.removeAttribute("userId");
    }

    @GetMapping(value = { "/getInfo", "/{userId}" })
    public Map getInfo(@PathVariable(value = "userId", required = false) Long userId,HttpSession session) {
        userId = (Long) session.getAttribute("userId");
        User user = userService.getUserByUserId(userId);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("user",user);
        return map;
    }

    @GetMapping("getRouters/{role}")
    public List<RouterVo> getRouters(@PathVariable(value = "role") Integer role) {
        List<Res> menus = resService.selectMenuTreeByUserId(role);
        return resService.buildMenus(menus);
    }

    @PostMapping
    public AjaxResult add(@RequestBody User user) {
        if (StringUtil.isNotEmpty(user.getPhoneNumber())
                && "NOT_UNIQUE".equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtil.isNotEmpty(user.getEmail())
                && "NOT_UNIQUE".equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return toAjax(userService.insertUser(user));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody User user) {
        if (StringUtil.isNotEmpty(user.getPhoneNumber())
                && "NOT_UNIQUE".equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtil.isNotEmpty(user.getEmail())
                && "NOT_UNIQUE".equals(userService.checkEmailUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        return toAjax(userService.updateUser(user));
    }

    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
//        if (ArrayUtils.contains(userIds, SecurityUtil.getUserId())) {
//            return AjaxResult.error("当前用户不能删除");
//        }
        return toAjax(userService.deleteUserByIds(userIds));
    }

    @GetMapping("/resetPwd/{oldPassWord}/{newPassWord}")
    public AjaxResult resetPwd(@PathVariable("oldPassWord") String oldPassWord, @PathVariable("newPassWord") String newPassWord, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.getUserByUserId(userId);
        if(!oldPassWord.equals(user.getPassword())){
            return AjaxResult.error("原始密码错误！");
        }else {
            return toAjax(userService.resetUserPwd(userId,newPassWord));
        }
    }

    private AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
