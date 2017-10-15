package com.xavier.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>swagger-ui的配置</p>
 *
 * @author NewGr8Player
 * @date 2017/10/06
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /* 扫描的包 */
                .apis(RequestHandlerSelectors.basePackage("com.xavier.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("呦呵丶晓晓的个人博客接口说明文档")
                .description("NewGr8Player's personal Blog,Spring Boot Based.")
                .termsOfServiceUrl("http://github.com/NewGr8Player")
                .contact(new Contact("呦呵丶晓晓","273221594@qq.com","Xavier@programmer.net"))
                .version("1.0")
                .build();
    }

}
