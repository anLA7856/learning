package com.anla.msg;

/**
 * @user anLA7856
 * @time 18-11-7 下午11:55
 * @description 消息的尾部
 */
public class Tail {
    private int checkSum;

    public static final int byteSize = 4;

    public int getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }

    @Override
    public String toString() {
        return "Tail{" +
                "checkSum=" + checkSum +
                '}';
    }
}
