package org.jz.multiThreadDemo;

/**
 * @author Hongyi Zheng
 * @date 2018/7/10
 */
public class MyThread extends Thread {

    private int i;

    public MyThread(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
