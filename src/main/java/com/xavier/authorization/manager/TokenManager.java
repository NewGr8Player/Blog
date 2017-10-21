package com.xavier.authorization.manager;

import com.xavier.authorization.model.TokenModel;

/**
 * <p>对Token进行操作的接口</p>
 *
 * @author NewGr8PLayer
 * @date 2017/10/21
 */
public interface TokenManager {

    /**
     * <p>创建一个token关联上指定用户</p>
     *
     * @param userId 指定用户的id
     * @return 生成的token
     */
    TokenModel createToken(String userId);

    /**
     * <p>检查token是否有效</p>
     *
     * @param model token
     * @return 是否有效
     */
    boolean checkToken(TokenModel model);

    /**
     * <p>从字符串中解析token</p>
     *
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * <p>清除token</p>
     *
     * @param userId 登录用户的id
     */
    void deleteToken(String userId);

}
