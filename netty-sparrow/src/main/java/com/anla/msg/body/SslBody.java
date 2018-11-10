package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @author anLA7856
 * @createTime 18-11-8 下午11:10
 * @description ssl信息
 */


public class SslBody extends Body {

    private String sslVersion;
    public String getSslVersion() {
        return sslVersion;
    }
    public void setSslVersion(String sslVersion) {
        this.sslVersion = sslVersion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SslBody [");
        sb.append("sslVersion=").append(sslVersion).append("]");

        return sb.toString();
    }

    @Override
    public MsgType msgType() {
        return MsgType.SSL;
    }
}
