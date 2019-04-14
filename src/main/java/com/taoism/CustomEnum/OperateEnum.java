package com.taoism.CustomEnum;

/**
 * 操作类型
 *
 * @author 李嘉
 * @version 1.0
 * @Description 操作类型
 * @date 2019/1/8 15:16
 */
public enum OperateEnum {
    /**
     * 普通操作
     */
    None("普通操作", 0),

    /**
     * 新增操作
     */
    ADD("新增操作", 1),

    /**
     * 修改操作
     */
    EDIT("修改操作", 2),

    /**
     * 删除操作
     */
    REMOVE("删除操作", 3),

    /**
     * 测试操作
     */
    TEST("测试操作", 4),

    /**
     * 登陆操作
     */
    LOGIN("登陆操作", 5),

    /**
     * 登出操作
     */
    LOGOUT("登出操作", 6),

    /**
     * 授权操作
     */
    AUTHORIZATION("授权操作", 7),

    /**
     * 取消授权操作
     */
    DEAUTHORIZATION("取消授权操作", 8),

    /**
     * 禁用操作
     */
    DISENABLEAED("禁用操作", 9),

    /**
     * 启用操作
     */
    ENABLEAED("启用操作", 10),

    /**
     * 查询操作
     */
    SELECT("查询操作", 11),

    /**
     * 混合操作，新增或修改
     */
    ADDOREDIT("新增或修改操作", 12),

    /**
     * 下载操作
     */
    DOWNLOADED("下载操作", 13),

    /**
     * 上传操作
     */
    UPLOADED("上传操作", 14),

    /**
     * 流程处理
     */
    WORKFLOW("流程处理", 15),

    /**
     * 检查处理
     */
    CHECKED("检查处理", 16);

    private String name;
    private int index;

    private OperateEnum(){}

    private OperateEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (OperateEnum info : OperateEnum.values()) {
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
