package com.taoism.Util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 文件工具
 *
 * @author 李嘉
 * @version 1.0
 * @Description 文件工具
 * @date 2019/1/29 15:49
 */
public class FileUtil {

    /**
     * 保存文件到本地目录
     * @param file        二进制文件
     * @param filePath    文件路径
     * @param fileName    文件名称
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{

        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
