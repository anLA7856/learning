package com.anla.msg;

import java.util.HashMap;
import java.util.Map;

/**
 * @user anLA7856
 * @time 18-11-5 下午11:18
 * @description
 */
public enum MsgType {
    UNKNOWN((byte)0, "unknown"),
    SSL((byte)1, "SSL"),
    SYM_ENCRYPTION((byte)2, "SymEncryption"),
    RANDOM_CODE((byte)3, "RandomCode"),
    LOGIN_REQ((byte)4, "loginReq"),
    LOGIN_RESP((byte)5, "loginResp"),
    LOGOUT((byte)6, "logout"),
    HEARTBEAT_REQ((byte)7, "heartbeatReq"),
    HEARTBEAT_RESP((byte)8, "heartbeatResp");

    private final byte type;
    private final String desc;

    MsgType(byte type, String desc){   //不能用public修饰
        this.type = type;
        this.desc = desc;
    }

    public static MsgType getMsgTypeEnum(final Byte type){
        if(type == null){
            return null;
        }
        return MsgTypeHolder.getMsgTypeEnum(type);
    }

    public byte getType() {
        return type;
    }

    @Override
    public String toString() {
        return desc;
    }

    private static class MsgTypeHolder{
        private static Map<Byte, MsgType> msgTypeMap;
        static {
            msgTypeMap = new HashMap<>();
            for (MsgType type: MsgType.values()){
                msgTypeMap.put(type.getType(), type);
            }
        }
        public static MsgType getMsgTypeEnum(Byte key){
            if (msgTypeMap.containsKey(key)){
                return msgTypeMap.get(key);
            }
            return null;
        }
    }
}
