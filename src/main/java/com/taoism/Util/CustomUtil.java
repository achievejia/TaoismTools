package com.taoism.Util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * 自定义工具类
 *
 * @author 李嘉
 * @version 1.0
 * @Description 自定义工具类
 * @date 2019/1/8 17:50
 */
public class CustomUtil {

    /**
     * 生成ID,默认小写并且去掉横杆
     * @return
     */
    public static String GenerateID() {
        String[] uid = UUID.randomUUID().toString().split("-");
        StringBuffer tmpString = new StringBuffer();
        for (String tmp : uid) {
            tmpString.append(tmp);
        }
        return tmpString.toString();
    }

    /**
     * 生成空的字符串。32位0字符串
     * @return
     */
    public static String GenerateNullID() {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0
        // num 代表长度为4
        // d 代表参数为正数型
        result = String.format("%032d", 0);

        return result;
    }

    /**
     * 生成ID，默认小写
     * @param isHorizontaLine 是否需要横线
     * @return
     */
    public static String GenerateID(Boolean isHorizontaLine) {
        String tmpId = "";
        if (isHorizontaLine) {
            tmpId = UUID.randomUUID().toString();
        } else {
            String[] uid = UUID.randomUUID().toString().split("-");
            StringBuffer tmpString = new StringBuffer();
            for (String tmp : uid) {
                tmpString.append(tmp);
            }
            tmpId = tmpString.toString();
        }
        return tmpId;
    }

    /**
     * 生成ID
     * @param isHorizontaLine 是否需要横线
     * @param isUpper 是否需要大写
     * @return
     */
    public static String GenerateID(Boolean isHorizontaLine, Boolean isUpper) {
        String tmpId = "";
        if (isHorizontaLine) {
            tmpId = UUID.randomUUID().toString();
        } else {
            String[] uid = UUID.randomUUID().toString().split("-");
            StringBuffer tmpString = new StringBuffer();
            for (String tmp : uid) {
                tmpString.append(tmp);
            }
            tmpId = tmpString.toString();
        }
        if (isUpper) {
            tmpId = tmpId.toUpperCase();
        }
        return tmpId;
    }

    /**
     * 获取格式化的时间，默认是yyyy-MM-dd HH:mm:ss此格式
     * @return
     */
    public static String GetFormatTime() {
        DateTime dateTime = new DateTime().withZone(DateTimeZone.forID("Asia/Shanghai")).toLocalDateTime().toDateTime();
        try{
            return dateTime.toString("yyyy-MM-dd HH:mm:ss");
        } catch (Exception ex) {
            ex.printStackTrace();
            return dateTime.toString();
        }
    }

    /**
     * 获取格式化的时间
     * @param formatter 时间格式化字符串
     * @return
     */
    public static String GetFormatTime(String formatter) {
        DateTime dateTime = new DateTime().withZone(DateTimeZone.forID("Asia/Shanghai")).toLocalDateTime().toDateTime();
        try{
            return dateTime.toString(formatter);
        } catch (Exception ex) {
            ex.printStackTrace();
            return dateTime.toString("yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    public static String GetIPAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            System.out.println("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("getRemoteAddr ip: " + ip);
        }
        System.out.println("获取客户端ip: " + ip);
        return ip;
    }

    /**
     * 获取真实IP地址
     * @param request
     * @return
     */
    public static String GetIPAddressByInetAddress(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }


    /**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
    public static String AutoGenericCode(String code, int num) {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0
        // num 代表长度为4
        // d 代表参数为正数型
        result = String.format("%0" + num + "d", Integer.parseInt(code) + 1);

        return result;
    }

    /**
     * 获取文件的扩展名
     * @param fileName  文件名称
     * @return
     */
    public static String GetExtractName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

    /**
     * 字节大小转KB
     * @param size 字节大小
     * @return
     */
    public static double SizeBToKB(long size) {
        if (size <= 0) return 0;
        return new BigDecimal(size / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * 去掉多余的0
     * @param tmp
     * @return
     */
    public static String trimLeftZero(String tmp) {
        return tmp.replaceAll("^(0+)", "");
    }

    /**
     * 短时间变长时间
     * @param tmp   格式：20190301
     * @return
     */
    public static String sortTimeToLongTime(String tmp) {
        return tmp.substring(0, 4) + "-" + tmp.substring(4, 6) + "-" + tmp.substring(6, 8);
    }
}
