package com.taoism.CustomEnum;

/**
 * 删除枚举
 *
 * @author 李嘉
 * @version 1.0
 * @Description 删除枚举
 * @date 2019/1/21 16:11
 */
public enum DeletedEnum {
    /**
     * 不删除
     */
    NODELETE("不删除", 0),

    /**
     * 删除
     */
    DELETE("删除", 1);

    private String name;
    private int index;

    private DeletedEnum(){}

    private DeletedEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (DeletedEnum info : DeletedEnum.values()) {
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
