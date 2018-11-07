package com.anla.core;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @user anLA7856
 * @time 18-11-6 下午11:35
 * @description 解码器，对bytebuf的封装，注意读string
 */
public class Decoder {
    public static String readString(ByteBuf in) throws UnsupportedEncodingException {
        int byteSize = in.readInt();
        if(-1 == byteSize) {
            return null;
        }
        if(0 == byteSize) {
            return "";
        }
        byte[] bytes = new byte[byteSize];
        readBytes(in, bytes);
        return new String(bytes, "UTF-8");
    }

    public static void readBytes(ByteBuf in, byte[] dst) {
        in.readBytes(dst);
    }

    public static int readInt(ByteBuf in) {
        return in.readInt();
    }

    public static long readLong(ByteBuf in) {
        return in.readLong();
    }

    public static byte readByte(ByteBuf in) {
        return in.readByte();
    }

    public static double readDouble(ByteBuf in) {
        return in.readDouble();
    }

    public static short readShort(ByteBuf in) {
        return in.readShort();
    }

    public static boolean readBoolean(ByteBuf in){
        return in.readBoolean();
    }
}
