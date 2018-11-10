package com.anla.msg.serializer;

import com.anla.core.Decoder;
import com.anla.core.Encoder;
import com.anla.msg.Tail;
import com.anla.msg.util.CommenUtil;
import io.netty.buffer.ByteBuf;

/**
 * @user anLA7856
 * @time 18-11-8 下午10:54
 * @description
 */
public class TailSerializer {
    private static final TailSerializer INSTANCE = new TailSerializer();

    public static TailSerializer getInstance(){ return INSTANCE; }

    public void serializer(ByteBuf out){
        int checkSum = CommenUtil.checkSum(out, out.writerIndex());
        Encoder.writeInt(out, checkSum);
    }

    public Tail deserializer(ByteBuf in){
        int checkSum = Decoder.readInt(in);
        Tail tail = new Tail();
        tail.setCheckSum(checkSum);
        return tail;
    }
}
