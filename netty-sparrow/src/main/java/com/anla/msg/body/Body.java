package com.anla.msg.body;

import com.anla.msg.MsgType;

/**
 * @user anLA7856
 * @time 18-11-6 下午11:54
 * @description body的共用基类
 */
public class Body {
    public MsgType msgType(){ return MsgType.UNKNOWN; }
}
