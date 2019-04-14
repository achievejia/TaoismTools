package com.taoism.Util;

/**
 * 设备工具
 *
 * @author Origi
 * @version 1.0
 * @date 2018/5/17 16:08
 **/
public class DrivceUtil {

    private static String[] drivceArray = {"Android", "iPad", "iPod", "iPhone", "Windows Phone", "okhttp"};

    /**
     * 判断请求来源
     * @param requestHeader 请求头
     * @return
     */
    public static boolean isMobileDevice(String requestHeader) {
        if (requestHeader == null) {
            return false;
        }
        for (int i = 0; i < drivceArray.length; i++) {
            if (requestHeader.toLowerCase().indexOf(drivceArray[i].toLowerCase()) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取设备信息
     * @param requestHeader  请求头
     * @return
     */
    public static String getDrivceInfo(String requestHeader) {
        return requestHeader.toLowerCase();
    }
}
