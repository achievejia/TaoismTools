package com.taoism.Util;

import com.taoism.CustomEnum.ResultEnum;

/**
 * 自定义异常
 *
 * @author 李嘉
 * @version 1.0
 * @Description 自定义异常
 * @date 2019/1/23 15:12
 */
public class CustomException extends RuntimeException {

    private Integer code;

    /**
     * 自定义枚举异常错误 构造函数
     * @param resultEnum
     */
    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getName());
        this.code = resultEnum.getIndex();
    }

    /**
     * 自定义异常错误代码，消息  构造函数
     * @param code      错误代码
     * @param message   消息
     */
    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
