package com.taoism.CustomEnum;

/**
 * 日志类型枚举
 *
 * @author 李嘉
 * @version 1.0
 * @Description 日志类型枚举
 * @date 2019/3/12 14:47
 */
public enum LogEnum {
    NONE("普通日志", 0),
    PAY("支付日志", 1),
    SYS("系统日志", 2),
    TRAC("异常日志", 3);

    private String name;
    private int index;

    private LogEnum() {
    }

    private LogEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (LogEnum info : LogEnum.values()) {
            if (info.getIndex() == index) {
                return info.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
