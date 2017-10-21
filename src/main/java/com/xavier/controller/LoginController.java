package com.xavier.controller;

import com.xavier.authorization.annotation.Authorization;
import com.xavier.authorization.manager.TokenManager;
import com.xavier.authorization.model.TokenModel;
import com.xavier.config.ResultStatus;
import com.xavier.domain.User;
import com.xavier.model.ResultModel;
import com.xavier.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>用户登录接口</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 */
@Api(value = "/login", description = "登录接口")
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "用户登录")
    public ResponseEntity<ResultModel> login(User loginUser) {
        Assert.notNull(loginUser.getUsername(), "用户名不能为空");
        Assert.notNull(loginUser.getPassword(), "密码不能为空");

        User user = userRepository.findFirstByUsername(loginUser.getUsername());
        if (user == null ||  /* 未注册 */
                !user.getPassword().equals(loginUser.getPassword())) {  /* 密码错误 */
            /* 提示用户名或密码错误 */
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        TokenModel model = tokenManager.createToken(user.getId());
        /* 生成一个token，保存用户登录状态 */
        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    @ApiOperation(value = "退出", notes = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "权限Token串", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query")
    })
    public ResponseEntity<ResultModel> logout(String username) {
        User user = userRepository.findFirstByUsername(username);
        if(null != user) {
            tokenManager.deleteToken(user.getId());
            return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

    }
}
