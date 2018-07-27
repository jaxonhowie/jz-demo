package org.jz.table2Image.html2Img;

import gui.ava.html.image.generator.HtmlImageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.*;

/**
 * @author Hongyi Zheng
 * @date 2018/7/25
 */
public class TestDemo {

    private static final Logger logger = LoggerFactory.getLogger(TestDemo.class);

    /**
     * html文件以指定字符集读取为String
     *
     * @param filePath
     * @param charset
     * @return
     */
    public static String getHtmlString(String filePath, String charset) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), charset));
            while (null != (line = br.readLine())) {
                sb.append(line + "\n");
                logger.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    /**
     * html转image
     *
     * @param html html String
     * @param targetDir 图片存储位置
     * @return  返回存储路径
     */
    public static String html2Img(String html, String targetDir) {
        HtmlImageGenerator generator = new HtmlImageGenerator();
        try {
            generator.loadHtml(html);
            Thread.sleep(100);
            generator.getBufferedImage();
            Thread.sleep(200);
            generator.saveAsImage(targetDir);
            BufferedImage source = ImageIO.read(new File(targetDir));
            source = trans2Gray24BitMap(source);
            ImageIO.write(source, "BMP", new File(targetDir));
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetDir;
    }

    private static BufferedImage trans2Gray24BitMap(BufferedImage image){

        int h = image.getHeight();
        int w = image.getWidth();
        // 定义数组，用来存储图片的像素
        int[] pixels = new int[w * h];
        int gray;
        PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
        try {
            pg.grabPixels(); // 读取像素值
        } catch (InterruptedException e) {
            throw new RuntimeException("转换成24位图的BMP时，处理像素值异常");
        }
        // 扫描列
        for (int j = 0; j < h; j++){
            // 扫描行
            for (int i = 0; i < w; i++) {
                // 由红，绿，蓝值得到灰度值
                gray = (int) (((pixels[w * j + i] >> 16) & 0xff) * 0.8);
                gray += (int) (((pixels[w * j + i] >> 8) & 0xff) * 0.1);
                gray += (int) (((pixels[w * j + i]) & 0xff) * 0.1);
                pixels[w * j + i] = (255 << 24) | (gray << 16) | (gray << 8) | gray;
            }
        }

        MemoryImageSource s= new MemoryImageSource(w,h,pixels,0,w);
        Image img =Toolkit.getDefaultToolkit().createImage(s);
        //如果要转换成别的位图，改这个常量即可
        BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        buf.createGraphics().drawImage(img, 0, 0, null);
        return buf;
    }


    public static void main(String[] args) {
        String charset = "UTF-8";
        String targetDir = "D:\\testfiles\\test.png";
        String filePath = "D:/testfiles/0628/1abcda24f9964d97bc1f50d7eb9f1c80.html";
        String html = getHtmlString(filePath, charset);
        html2Img(html, targetDir);
    }


}
