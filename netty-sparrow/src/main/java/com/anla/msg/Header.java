package com.anla.msg;

/**
 * @user anLA7856
 * @time 18-11-5 下午11:15
 * @description 消息头部
 */
public class Header {
    private long msgNum;  // 发送消息数目
    private MsgType type;
    private String msgTime;

    public long getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(long msgNum) {
        this.msgNum = msgNum;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Header [");
        builder.append("msgNum=").append(msgNum);
        builder.append(", type=").append(type);
        builder.append(", msgTime='").append(msgTime).append("'");
        return builder.toString();
    }
}
