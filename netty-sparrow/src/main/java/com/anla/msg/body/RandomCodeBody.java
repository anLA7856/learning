package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @author anLA7856
 * @createTime 18-11-9 下午11:39
 * @description
 */


public class RandomCodeBody extends Body {

    private String randomCode;

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RandomCodeBody [");
        sb.append("randomCode=").append(randomCode).append("]");
        return sb.toString();
    }

    @Override
    public MsgType msgType() {
        return MsgType.RANDOM_CODE;
    }
}
