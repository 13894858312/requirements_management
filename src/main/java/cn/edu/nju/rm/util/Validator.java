package cn.edu.nju.rm.util;

import java.util.regex.Pattern;

/**
 * 属性验证工具
 */
public class Validator {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证正整数
     */
    public static final String REGEX_POSITIVE_INTEGER = "^[0-9]*[1-9][0-9]*$";

    /**
     * 正则表达式：验证UID
     */
    public static final String REGEX_UID = "[\\u4e00-\\u9fa5_a-zA-Z0-9_]{4,32}";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "[\\u4e00-\\u9fa5_a-zA-Z0-9_]{6,32}" ;

    /**
     * 校验手机号
     * @param str
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String str) {
        return Pattern.matches(REGEX_MOBILE, str);
    }

    /**
     * 校验邮箱
     * @param str
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String str) {
        return Pattern.matches(REGEX_EMAIL, str);
    }

    /**
     * 校验身份证
     * @param str
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String str) {
        return Pattern.matches(REGEX_UID, str);
    }

    /**
     * 校验正整数
     * @param str
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPositiveInteger(String str) {
        return Pattern.matches(REGEX_PASSWORD, str);
    }

    /**
     * 校验uid
     * @param str
     * @return 校验通过返回true，否则返回false
     */
    public boolean isUid(String str) {
        return Pattern.matches(REGEX_POSITIVE_INTEGER, str);
    }

    /**
     * 校验password
     * @param str
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String str) {
        return Pattern.matches(REGEX_POSITIVE_INTEGER, str);
    }

//    public static void main(String[] args) {
//        String str = "15852731771";
//        boolean flag = isMobile(str);
//        System.out.println(flag);
//    }

}
