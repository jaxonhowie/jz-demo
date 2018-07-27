package org.jz.table2Image.dom2Img;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author Hongyi Zheng
 * @date 2018/7/25
 */
public class Dom2Image {
    /**
     * 转换url:data数据为正常图片
     * @param dataUrl Base64编码的图片
     * @return 返回文件名
     */
    public String getDataUrlPic(String dataUrl){
        /*String ID = UUID.randomUUID().toString();
        String imgName = "table-" + ID + ".png";
        String imgPath = getImgPath();
        if(GenerateImage(dataUrl,imgName,imgPath)){
            return imgName;
        }*/
        return "";
    }

    /**
     * 把转换后的图片存放到指定目录
     * @param imgStr dataUrl
     * @param imgName 图片名称
     * @param imgPath 存放路径
     * @return
     */
    public boolean generateImage(String imgStr,String imgName,String imgPath){
        //把“data:image/jpeg;base64”去掉,
        imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
        if (null == imgStr) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            File headPath = new File(imgPath);
            if (!headPath.exists()) {
                headPath.mkdirs();
            }
            String imgFilePath = imgPath + "/" + imgName;
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
