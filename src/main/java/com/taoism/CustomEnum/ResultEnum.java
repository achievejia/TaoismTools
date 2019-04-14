package com.taoism.CustomEnum;

/**
 * 返回结果枚举
 *
 * @author 李嘉
 * @version 1.0
 * @Description 返回结果枚举
 * @date 2019/1/8 15:24
 */
public enum ResultEnum {

    /**
     * 无操作
     */
    None("无操作", 0),

    /**
     * 成功
     */
    Success("成功", 10200),

    /**
     * 失败
     */
    Fail("失败", 10500),

    /**
     * 未授权
     */
    NoAuthorization("未授权", 10400),

    /**
     * 登陆超时
     */
    LOGINTIMEOUT("登陆超时", 10410),

    /**
     * 初次登录
     */
    LOGINGINIT("初次登录", 10411),

    /**
     * 未找到请求
     */
    NotFoundRequest("未找到请求", 10401),

    /**
     * 未查询到数据
     */
    NotFoundData("未查询到数据", 10402),

    /**
     * 未传递参数
     */
    NoParameter("未传递参数", 10403),

    /**
     * 参数个数不对
     */
    ParameterNoNum("参数个数不对", 10405),

    /**
     * 参数格式化失败
     */
    ParameterFormatErr("参数格式化失败", 10406),

    /**
     * 请求超时
     */
    RequestTimeOut("请求超时", 10407),

    /**
     * 查询超时
     */
    DataTimeOut("查询超时", 10408),

    /**
     * 数据过期
     */
    Expired("数据过期", 10409),

    /**
     * 数据错误
     */
    Error("数据错误", 10420);

    private String name;
    private int index;

    private ResultEnum() {
    }

    private ResultEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (ResultEnum info : ResultEnum.values()) {
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
