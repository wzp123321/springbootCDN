package com.springboot.demo.utlis;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 处理文件上传的工具类
 */
@Component
public class FileUtils {
    public void HanleUpload(MultipartFile file, String filename) {
        // 统一上传的文件存储位置
        File filePath = new File("D:/uploadImgs");
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        try {
            FileOutputStream fos = new FileOutputStream(filePath+"/"+filename);
            fos.write(file.getBytes());
            File f = new File(filePath+"/"+filename);
            // 计算文件md5值
            String fileMD5 = FileUtils.getFileMD5(f);
            File f1 = new File(fileMD5+"."+filename.substring(filename.lastIndexOf(".")+1));
            fos.flush(); // 清空缓冲区
            fos.close(); // 关闭资源
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getFileMD5(File file){
        BigInteger bigInt = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            bigInt = new BigInteger(1, md.digest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bigInt.toString(16);
    }
}
