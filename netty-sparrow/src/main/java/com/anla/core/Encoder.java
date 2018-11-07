package com.anla.core;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @user anLA7856
 * @time 18-11-6 下午11:23
 * @description 编码器
 */
public class Encoder {

    public static void writeString(ByteBuf out, String value) throws UnsupportedEncodingException {
        if (value == null){
            out.writeInt(-1);
            return;
        }
        if (value.isEmpty()){
            out.writeInt(0);
            return;
        }

        byte[] data = value.getBytes("UTF-8");
        out.writeInt(data.length);
        out.writeBytes(data);
    }

    public static void writeBytes(ByteBuf out, byte[] bytes) {
        out.writeBytes(bytes);
    }

    /**
     * 序列化{@code Integer} 值
     */
    public static void writeInt(ByteBuf out, int value) {
        out.writeInt(value);
    }

    public static void writeBoolean(ByteBuf out, boolean value) { out.writeBoolean(value);}

    public static void writeLong(ByteBuf out, long value) {
        out.writeLong(value);
    }

    public static void writeByte(ByteBuf out, byte value) {
        out.writeByte(value);
    }

    public static void writeDouble(ByteBuf out, double value) {
        out.writeDouble(value);
    }

    public static void writeShort(ByteBuf out, short value) {
        out.writeShort(value);
    }



}
