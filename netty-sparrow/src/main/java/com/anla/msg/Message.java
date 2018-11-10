package com.anla.msg;

/**
 * @user anLA7856
 * @time 18-11-8 下午11:14
 * @description 实际发送的消息
 */
public class Message {
    private Header header;
    private Body body;
    private Tail tail;

    public static Message createMsgOfEncode(Body body){ return new Message(body); }
    public static Message createMsgOfDecode(Header header, Body body, Tail tail){ return new Message(header, body, tail); }

    public Message(Header header, Body body, Tail tail) {
        this.header = header;
        this.body = body;
        this.tail = tail;
    }

    public Message(Body body) {
        this.header = new Header();
        this.body = body;
        this.tail = new Tail();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Tail getTail() {
        return tail;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }


    @Override
    public String toString() {
        return "Message{" +
                "header=" + header +
                ", body=" + body +
                ", tail=" + tail +
                '}';
    }
}
