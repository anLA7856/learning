package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @author anLA7856
 * @createTime 18-11-8 下午11:21
 * @description 登陆消息
 */


public class LoginRespBody extends Body {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginRespBody []");
        return sb.toString();
    }

    @Override
    public MsgType msgType() {
        return MsgType.LOGIN_RESP;
    }
}
