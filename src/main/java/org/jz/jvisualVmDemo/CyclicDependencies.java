package org.jz.jvisualVmDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hongyi Zheng
 * @date 2018/6/27
 */
public class CyclicDependencies {

    private static final Map map = new HashMap();

    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
