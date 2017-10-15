package com.xavier.authorization.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {


    /**
     * <p>SHA-256加密</p>
     */
    public static final String SHA256 = "SHA-256";
    /**
     * <p>SHA-512加密</p>
     */
    public static final String SHA512 = "SHA-512";
    /**
     * <p>MD5加密</p>
     */
    public static final String MD5 = "MD5";

    /**
     * <p>字符串加密</p>
     *
     * @param strText (加密文本)
     * @param digesttrType (机密类型)
     * @return String (加密后的字符串)
     */
    private String SHA(final String strText, final String digesttrType) {
        /* 返回值 */
        String strResult = null;

        /* 是否是有效字符串 */
        if (strText != null && strText.length() > 0) {
            try {
                /* SHA 加密开始 */
                // 创建加密对象 并传入加密类型 */
                MessageDigest messageDigest = MessageDigest.getInstance(digesttrType);
                /* 传入要加密的字符串 */
                messageDigest.update(strText.getBytes());
                /* 得到 byte 类型结果 */
                byte byteBuffer[] = messageDigest.digest();

                /* 将 byte 转换为 string */
                StringBuffer strHexString = new StringBuffer();
                /* 遍历 byte buffer */
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                /* 得到返回结果 */
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }
}
