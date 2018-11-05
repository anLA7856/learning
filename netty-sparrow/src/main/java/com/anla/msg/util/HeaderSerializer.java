package com.anla.msg.util;

import com.anla.msg.Header;
import io.netty.buffer.ByteBuf;

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
        Enco
    }
}
