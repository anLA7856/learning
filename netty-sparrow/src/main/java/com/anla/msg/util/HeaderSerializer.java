package com.anla.msg.util;

import com.anla.core.Decoder;
import com.anla.core.Encoder;
import com.anla.msg.Header;
import com.anla.msg.MsgType;
import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @user anLA7856
 * @time 18-11-5 下午11:42
 * @description 解析头部
 */
public class HeaderSerializer {
    private static final HeaderSerializer SERIALIZER = new HeaderSerializer();

    public static HeaderSerializer getInstance(){
        return SERIALIZER;
    }

    public void serialize(ByteBuf out, Header header) throws Exception{
        Encoder.writeLong(out, header.getMsgNum());
        Encoder.writeByte(out, header.getType().getType());
        Encoder.writeString(out, header.getMsgTime());
    }

    public Header deserialize(ByteBuf in) throws UnsupportedEncodingException {
        long msgNum = Decoder.readLong(in);
        byte type = Decoder.readByte(in);
        String msgTime = Decoder.readString(in);
        Header header = new Header();
        header.setMsgNum(msgNum);
        header.setType(MsgType.getMsgTypeEnum(type));
        header.setMsgTime(msgTime);
        return header;
    }
}
