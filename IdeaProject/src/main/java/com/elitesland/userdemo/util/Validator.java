package com.elitesland.userdemo.util;

/**
 * 验证器，用于验证字符串的格式是否正确
 */
public final class Validator {

    private Validator() {
        super();
    }

    /**
     * 验证用户名的正则表达式
     */
    public static final String REGEX_USERNAME
            = "^[A-Za-z][A-Za-z1-9_-]+$";


    /**
     * (^\d{18}$)|(^\d{17}(\d|X|x)$)
     * 验证身份证号码的正则表达式
     */
    public static final String REGEX_IDNUM
            = "(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";



    /**
     * 验证用户名
     * @param username 需要被验证格式的用户名
     * @return 如果符合格式要求，则返回true，否则返回false
     */
    public static boolean checkUsername(String username) {
        return username.matches(REGEX_USERNAME);
    }

    /**
     * 验证身份证号码
     *
     * @param IDnum 需要被验证格式的密码
     * @return 如果符合格式要求，则返回true，否则返回false
     */
    public static boolean checkIDnum(String IDnum) {
        return IDnum.matches(REGEX_IDNUM);
    }

}
