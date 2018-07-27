package org.jz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Hongyi Zheng
 * @date 2018/7/27
 */
public class ExecuteUtils {

    private static final String INPUT = "i";
    private static final String ERROR = "e";

    public static Process exec(String cmd) throws IOException {
        return Runtime.getRuntime().exec(cmd);
    }

    public static String getInputInfo(Process p) throws IOException {
        return getInfo(p, INPUT);
    }

    public static String getErrorInfo(Process p) throws IOException {
        return getInfo(p, ERROR);
    }

    private static String getInfo(Process p, String f) throws IOException {
        if (null == f) {
            return null;
        }

        InputStream is;
        switch (f) {
            case "i":
                is = p.getInputStream();
                break;
            case "e":
                is = p.getErrorStream();
                break;
            default:
                return null;
        }

        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
