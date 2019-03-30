package com.taoism.Safety;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 *
 * @author 李嘉
 * @version 1.0
 * @Description MD5加密
 * @date 2019/1/22 11:10
 */
public class MD5 {
    /**
     * MD5加密，小写
     * @param sourceStr  待加密字符串
     * @return
     */
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * MD5大小写
     * @param sourceStr  待加密字符串
     * @param IsUpper    是否大写
     * @return
     */
    public static String MD5(String sourceStr, Boolean IsUpper) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            if (IsUpper) {
                result = result.toUpperCase();
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * MD5加密
     * @param inStr 待加密字符串
     * @return
     */
//    public static String Md5(String inStr){
//        String result = "";
//        try {
//            MessageDigest md5 = null;
//            try{
//                md5 = MessageDigest.getInstance("MD5");
//            }catch (Exception e){
//                System.out.println(e.toString());
//                e.printStackTrace();
//            }
//            char[] charArray = inStr.toCharArray();
//            byte[] byteArray = new byte[charArray.length];
//
//            for (int i = 0; i < charArray.length; i++)
//                byteArray[i] = (byte) charArray[i];
//            byte[] md5Bytes = md5.digest(byteArray);
//            StringBuffer hexValue = new StringBuffer();
//            for (int i = 0; i < md5Bytes.length; i++){
//                int val = ((int) md5Bytes[i]) & 0xff;
//                if (val < 16)
//                    hexValue.append("0");
//                hexValue.append(Integer.toHexString(val));
//            }
//            result = hexValue.toString();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return result;
//
//    }

    /**
     * MD5加密
     * @param inStr   待加密字符串
     * @param IsUpper 是否大写
     * @return
     */
//    public static String Md5(String inStr, Boolean IsUpper){
//        String result = "";
//        try {
//            MessageDigest md5 = null;
//            try{
//                md5 = MessageDigest.getInstance("MD5");
//            }catch (Exception e){
//                System.out.println(e.toString());
//                e.printStackTrace();
//            }
//            char[] charArray = inStr.toCharArray();
//            byte[] byteArray = new byte[charArray.length];
//
//            for (int i = 0; i < charArray.length; i++)
//                byteArray[i] = (byte) charArray[i];
//            byte[] md5Bytes = md5.digest(byteArray);
//            StringBuffer hexValue = new StringBuffer();
//            for (int i = 0; i < md5Bytes.length; i++){
//                int val = ((int) md5Bytes[i]) & 0xff;
//                if (val < 16)
//                    hexValue.append("0");
//                hexValue.append(Integer.toHexString(val));
//            }
//            result = hexValue.toString();
//            if (IsUpper) {
//                result = result.toUpperCase();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return result;
//
//    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     * @param inStr
     * @return
     */
//    public static String convertMD5(String inStr){
//
//        char[] a = inStr.toCharArray();
//        for (int i = 0; i < a.length; i++){
//            a[i] = (char) (a[i] ^ 't');
//        }
//        String s = new String(a);
//        return s;
//
//    }
}
