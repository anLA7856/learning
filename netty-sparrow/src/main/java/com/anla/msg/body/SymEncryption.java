package com.anla.msg.body;

import com.anla.msg.Body;
import com.anla.msg.MsgType;

/**
 * @author anLA7856
 * @createTime 2018/7/28
 * @description 对称加密方法
 */


public class SymEncryption extends Body {
    private String symEncryptionMethod;

    public String getSymEncryptionMethod() {
        return symEncryptionMethod;
    }

    public void setSymEncryptionMethod(String symEncryptionMethod) {
        this.symEncryptionMethod = symEncryptionMethod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SymEncryption [");
        sb.append("symEncryptionMethod=").append(symEncryptionMethod).append("]");

        return sb.toString();
    }

    @Override
    public MsgType msgType() {
        return MsgType.SYM_ENCRYPTION;
    }
}
