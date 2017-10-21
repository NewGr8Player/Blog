package com.xavier.authorization.manager.impl;

import com.xavier.authorization.manager.TokenManager;
import com.xavier.authorization.model.TokenModel;
import com.xavier.authorization.util.TokenUtil;
import com.xavier.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>通过Redis存储和验证token的实现类</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 * @see com.xavier.authorization.manager
 */
@Component
public class RedisTokenManager implements TokenManager {

    private StringRedisTemplate redis;

    @Autowired
    public void setRedis(StringRedisTemplate redis) {
        this.redis = redis;
    }

    public TokenModel createToken(String userId) {
        String token = TokenUtil.Generator();
        TokenModel model = new TokenModel(userId, token);
        /* 存储到redis并设置过期时间 */
        redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_TIME, TimeUnit.SECONDS);
        return model;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        /* 使用userId和源token简单拼接成的token，可以增加加密措施 */
        String userId = param[0];
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redis.boundValueOps(model.getUserId()).get();
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        /* 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间 */
        redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_TIME, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(String userId) {
        redis.delete(userId);
    }
}
