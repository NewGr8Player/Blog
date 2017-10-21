package com.xavier.authorization.util;

import java.util.UUID;

/**
 * <p>Tocken串生成工具类</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 */
public class TokenUtil {

    /**
     * <p>Tocken生成方法</p>
     *
     * @return String Token串
     */
    public static String Generator() {
        /* 使用uuid作为源token */
        String uuidSource = UUID.randomUUID().toString().replace("-", "");
        return EncryptUtil.SHA(uuidSource, EncryptUtil.SHA256);
    }
}
