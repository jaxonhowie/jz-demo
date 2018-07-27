package org.jz.multiThreadDemo;

/**
 * @author Hongyi Zheng
 * @date 2018/7/10
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("运行中!");
    }
}
