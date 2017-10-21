package com.xavier.util;

/**
 * <p>字符串工具类</p>
 *
 * @author NewGr8Player
 * @since 2017/10/13
 */
public class StringKit {

    /**
     * <p>字符串为 null 或者内部字符全部为 ' ' '\t' '\n' '\r' 这四类字符时返回 true</p>
     */
    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int len = str.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    // case '\b':
                    // case '\f':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /**
     * <p>字符串不为空</p>
     *
     * @return boolean
     * @see StringKit isBlank
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
