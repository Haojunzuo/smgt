package com.wbz.system.domain;

public class LoginBody {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;
    /**
     * 角色:1-学生 2-辅导员 3-教务处
     */
    private Integer role;

    /**
     * 验证码
     */
    private String code;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LoginBody{" +
                "username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", code='" + code + '\'' +
                '}';
    }
}
