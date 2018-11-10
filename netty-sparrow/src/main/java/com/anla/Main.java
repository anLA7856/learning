package com.anla;

import com.anla.client.Client;
import com.anla.server.Server;

/**
 * @user anLA7856
 * @time 18-11-10 下午8:58
 * @description 启动类
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> new Server().start(8989)).start();
        Thread.sleep(5000);
        new Thread(() -> new Client().start("127.0.0.1", 8989)).start();
    }
}
