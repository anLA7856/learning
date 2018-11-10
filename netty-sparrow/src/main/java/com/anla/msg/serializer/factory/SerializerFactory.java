package com.anla.msg.serializer.factory;

import com.anla.msg.MsgType;
import com.anla.msg.Body;
import com.anla.msg.serializer.*;

import java.util.EnumMap;

/**
 * @user anLA7856
 * @time 18-11-7 下午11:48
 * @description
 */
public final class SerializerFactory {
    private SerializerFactory() {
        // 直接不允许
        throw new IllegalAccessError("can not use constructor.");
    }

    private static EnumMap<MsgType, BodySerializer<? extends Body>> bodySerializerMap = new EnumMap<>(MsgType.class);

    static {
        bodySerializerMap.put(MsgType.UNKNOWN, DefaultBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.SSL, SslBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.SYM_ENCRYPTION, SymEncryptionSerializer.getInstance());
        bodySerializerMap.put(MsgType.RANDOM_CODE, RandomCodeBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.LOGIN_REQ, LoginReqBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.LOGIN_RESP, LoginRespBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.LOGOUT, LogoutBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.HEARTBEAT_REQ, HeartReqBodySerializer.getInstance());
        bodySerializerMap.put(MsgType.HEARTBEAT_RESP, HeartRespBodySerializer.getInstance());
    }

    public static BodySerializer<? extends Body> getBodySerializer(final MsgType msgType) {
        BodySerializer<? extends Body> bodySerializer = bodySerializerMap.get(msgType);
        return null != bodySerializer ? bodySerializer: DefaultBodySerializer.getInstance();
    }
}
