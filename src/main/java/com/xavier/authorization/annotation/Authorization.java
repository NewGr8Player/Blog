package com.xavier.authorization.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误</p>
 *
 * @author NewGr8Player
 * @date 2017/10/15
 * @see com.xavier.authorization.interceptor.AuthorizationInterceptor
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
