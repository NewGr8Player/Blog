package com.xavier.controller;

import com.xavier.config.ResultStatus;
import com.xavier.domain.User;
import com.xavier.model.ResultModel;
import com.xavier.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射</p>
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public ResponseEntity<ResultModel> login(@RequestParam @ApiParam(name = "username", value = "用户名", required = true) String username,
                                             @RequestParam @ApiParam(name = "password", value = "密码", required = true) String password) {
        Assert.notNull(username, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");

        User user = userRepository.findByUsername(username);
        if (user == null ||  /* 未注册 */
                !user.getPassword().equals(password)) {  /* 密码错误 */
            /* 提示用户名或密码错误 */
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        /* 生成一个token，保存用户登录状态 */
        return new ResponseEntity<>(ResultModel.ok("OK"), HttpStatus.OK);
    }
}
