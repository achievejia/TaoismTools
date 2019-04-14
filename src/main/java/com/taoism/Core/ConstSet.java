package com.taoism.Core;

/**
 * 常量设置
 *
 * @author 李嘉
 * @version 1.0
 * @Description 常量设置
 * @date 2019/3/30 16:17
 */
public class ConstSet {
    /**
     * 密码加密Key
     */
    public static final long pwdKey = 0x496324baL;

    /**
     * SESSION 的常量名称
     */
    public class SessionName {
        public static final String SESSION_CURRENT_USER = "CurrentUser";

        public static final String COOKIE_REMBERME = "RememberMe";

        public static final String SESSION_CURRENT_ROLES = "CurrentRoleCode";

        /**
         * 当前用户可以操作的菜单
         */
        public static final String SESSION_CURRENT_USER_MENUS = "CurrentUserMenus";
    }

    /**
     * 页面参数名定义
     */
    public class RequestCode
    {
        public static final String UserName = "uid";

        public static final String Password = "pwd";

        public static final String GoPage = "gopage";

        public static final String mUserName = "uid";

        public static final String mPassword = "pwd";

        public static final String mGoPage = "gopage";
    }
}
