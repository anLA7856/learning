package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @author anLA7856
 * @createTime 18-11-8 下午11:26
 * @description
 */


public class LogoutBody extends Body {
    @Override
    public MsgType msgType() {
        return MsgType.LOGOUT;
    }

    @Override
    public String toString() {
        return "LogoutBody []";
    }
}
