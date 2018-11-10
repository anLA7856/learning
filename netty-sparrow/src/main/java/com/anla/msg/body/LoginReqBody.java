package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @user anLA7856
 * @time 18-11-7 下午11:31
 * @description
 */
public class LoginReqBody extends Body {
    private String userName;
    private String password;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginReqBody [");
        sb.append("userName=").append(userName);
        sb.append(", password=").append(password).append("]");

        return sb.toString();
    }

    @Override
    public MsgType msgType() {
        return MsgType.LOGIN_REQ;
    }
}
