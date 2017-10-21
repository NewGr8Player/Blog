package com.xavier.authorization.interceptor;

import com.xavier.authorization.annotation.Authorization;
import com.xavier.authorization.manager.TokenManager;
import com.xavier.authorization.model.TokenModel;
import com.xavier.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * <p>自定义拦截器，判断此次请求是否有权限</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 * @see com.xavier.authorization.annotation.Authorization
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager manager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        /* 如果不是映射到方法直接通过 */
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        /* 从header中得到token */
        String authorization = request.getHeader(Constants.AUTHORIZATION);
        /* 验证token */
        TokenModel model = manager.getToken(authorization);
        if (manager.checkToken(model)) {
            /* 如果token验证成功，将token对应的用户id存在request中，便于之后注入 */
            request.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
            return true;
        }
        /* 如果验证token失败，并且方法注明了Authorization，返回401错误 */
        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
