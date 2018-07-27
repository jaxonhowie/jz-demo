package org.jz.multiThreadDemo;

/**
 * @author Hongyi Zheng
 * @date 2018/7/10
 */
public class Test {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束！");
    }
}
