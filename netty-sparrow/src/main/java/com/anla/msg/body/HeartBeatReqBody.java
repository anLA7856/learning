package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @user anLA7856
 * @time 18-11-7 下午11:22
 * @description
 */
public class HeartBeatReqBody extends Body {
    @Override
    public MsgType msgType() {
        return MsgType.HEARTBEAT_REQ;
    }

    @Override
    public String toString() {
        return "HeartbeatReqBody []";
    }
}
