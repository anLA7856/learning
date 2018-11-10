package com.anla.msg.util;

import io.netty.buffer.ByteBuf;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @user anLA7856
 * @time 18-11-8 下午10:57
 * @description 用于计算字节包的长度
 */
public class CommenUtil {
    public static int checkSum(ByteBuf byteBuf, int length){
        if(length <= 0){
            throw new IllegalArgumentException("length <= 0");
        }
        byte checkSum = 0;
        length = Math.min(length, byteBuf.writerIndex());
        for (int i = 0; i < length;i++){
            checkSum += byteBuf.getByte(i);
        }
        return 0x00ff & checkSum;
    }

    public static int calCheckSum(byte[] bytes) {
        if(null == bytes) {
            throw new IllegalArgumentException("byte is null.");
        }
        byte checkSum = 0;
        for(int i =0; i<bytes.length; i++) {
            checkSum += bytes[i];
        }
        return 0x00ff & checkSum;
    }

    public static String nowTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateToStrFmt = DateTimeFormatter.ofPattern("yyyyMMdd hh:mm:ss");
        return dateToStrFmt.format(now);
    }
}
