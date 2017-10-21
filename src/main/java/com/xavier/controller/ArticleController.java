package com.xavier.controller;

import com.xavier.authorization.annotation.Authorization;
import com.xavier.config.ResultStatus;
import com.xavier.domain.Article;
import com.xavier.domain.User;
import com.xavier.model.ResultModel;
import com.xavier.repository.ArticleRepository;
import com.xavier.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>文章Entity</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 */
@Api(value = "/content", description = "内容接口")
@RestController
@RequestMapping(value = "/content")
public class ArticleController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;


    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    @ApiOperation(value = "新增", notes = "新增文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "authorization", value = "权限Token串", required = true, dataType = "string", paramType = "header")
    })
    public ResponseEntity<ResultModel> addContent(String username,@RequestBody Article article) {
        User user = this.userRepository.findFirstByUsername(username);
        if (null != user) {
            this.articleRepository.save(article);
            return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultModel.ok(ResultStatus.USER_NOT_FOUND), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
}
