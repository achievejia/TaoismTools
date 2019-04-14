package com.taoism.Util;

import com.taoism.CustomEnum.ResultEnum;

import java.math.BigDecimal;

/**
 * 自定义消息返回体
 *
 * @author 李嘉
 * @version 1.0
 * @Description 自定义消息返回体
 * @date 2019/1/8 19:40
 */
public class CustomResult {
    /**
     * 结果Id
     */
    private String ResultId = CustomUtil.GenerateID();

    /**
     * 是否成功
     */
    private boolean Success;

    /**
     * 代码编号
     */
    private Integer Code;

    /**
     * 数据集
     */
    private Object Data;

    /**
     * 消息
     */
    private String Message;

    /**
     * 堆栈异常错误消息
     */
    private String StackMessage;

    /**
     * 数据大小
     */
    private long Count;

    /**
     * 金额合计
     */
    private BigDecimal TotalAmount;

    /**
     * 最后更新时间
     */
    private String LastTime = CustomUtil.GetFormatTime();

    public CustomResult() {

    }

    public CustomResult(boolean success, Integer code, Object data, String message, long count, BigDecimal totalAmount) {
        this.Success = success;
        this.Code = code;
        this.Data = data;
        this.Message = message;
        this.Count = count;
        this.TotalAmount = totalAmount;
    }

    public CustomResult(boolean success, Integer code, Object data, String message, long count, BigDecimal totalAmount, String stackMessage) {
        this.Success = success;
        this.Code = code;
        this.Data = data;
        this.Message = message;
        this.Count = count;
        this.TotalAmount = totalAmount;
        this.StackMessage = stackMessage;
    }

    /**
     * 自定义生成结果对象
     * @param success
     * @param code
     * @return
     */
    public static CustomResult Build(boolean success, Integer code) {
        return new CustomResult(success, code, null, null, 0, null);
    }

    /**
     * 自定义生成结果对象
     * @param success
     * @param code
     * @param data
     * @return
     */
    public static CustomResult Build(boolean success, Integer code, Object data) {
        return new CustomResult(success, code, data, null, 0, null);
    }

    /**
     * 自定义生成结果对象
     * @param success
     * @param code
     * @param data
     * @param count
     * @return
     */
    public static CustomResult Build(boolean success, Integer code, Object data, long count) {
        return new CustomResult(success, code, data, null, count, null);
    }

    /**
     * 自定义生成结果对象
     * @param success
     * @param code
     * @param message
     * @return
     */
    public static CustomResult Build(boolean success, Integer code, String message) {
        return new CustomResult(success, code, null, message, 0, null);
    }

    /**
     * 自定义生成结果对象
     * @param success
     * @param code
     * @param data
     * @param message
     * @return
     */
    public static CustomResult Build(boolean success, Integer code, Object data, String message) {
        return new CustomResult(success, code, data, message, 0, null);
    }

    /**
     * 自定义生成结果对象
     * @param success
     * @param code
     * @param data
     * @param message
     * @param count
     * @return
     */
    public static CustomResult Build(boolean success, Integer code, Object data, String message, long count) {
        return new CustomResult(success, code, data, message, count, null);
    }

    /**
     * 成功
     * @return
     */
    public static CustomResult Ok() {
        return new CustomResult(true, ResultEnum.Success.getIndex(), null, null, 0, null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static CustomResult Ok(Object data) {
        return new CustomResult(true, ResultEnum.Success.getIndex(), data, null, 0, null);
    }

    /**
     * 成功
     * @param code
     * @param data
     * @return
     */
    public static CustomResult Ok(Integer code, Object data) {
        return new CustomResult(true, code, data, null, 0, null);
    }

    /**
     * 成功
     * @param data
     * @param count
     * @return
     */
    public static CustomResult Ok(Object data, long count) {
        return new CustomResult(true, ResultEnum.Success.getIndex(), data, null, count, null);
    }

    /**
     * 成功
     * @param data
     * @param count
     * @return
     */
    public static CustomResult Ok(Object data, long count, BigDecimal totalAmount) {
        return new CustomResult(true, ResultEnum.Success.getIndex(), data, null, count, totalAmount);
    }

    /**
     * 成功
     * @param code
     * @param data
     * @param count
     * @return
     */
    public static CustomResult Ok(Integer code, Object data, long count, BigDecimal totalAmount) {
        return new CustomResult(true, code, data, null, count, totalAmount);
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static CustomResult Fail(String message) {
        return new CustomResult(false, ResultEnum.Fail.getIndex(), null, message, 0, null);
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     */
    public static CustomResult Fail(Integer code, String message) {
        return new CustomResult(false, code, null, message, 0, null);
    }

    /**
     * 失败
     * @param message
     * @param stackMessage
     * @return
     */
    public static CustomResult Fail(String message, String stackMessage) {
        return new CustomResult(false, ResultEnum.Fail.getIndex(), null, message, 0, null, stackMessage);
    }

    /**
     * 失败
     * @param code
     * @param message
     * @param stackMessage
     * @return
     */
    public static CustomResult Fail(Integer code, String message, String stackMessage) {
        return new CustomResult(false, code, null, message, 0, null, stackMessage);
    }

    public String getResultId() {
        return ResultId;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public long getCount() {
        return Count;
    }

    public void setCount(long count) {
        Count = count;
    }

    public String getLastTime() {
        return LastTime;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.TotalAmount = totalAmount;
    }

    public String getStackMessage() {
        return StackMessage;
    }

    public void setStackMessage(String stackMessage) {
        StackMessage = stackMessage;
    }
}
