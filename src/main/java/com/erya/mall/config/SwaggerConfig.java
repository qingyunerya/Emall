package com.erya.mall.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
   public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("开发组");
    }

    @Bean
    public Docket Docket(Environment environment) {
        Profiles profiles= Profiles.of("dev","test");
        boolean flag=environment.acceptsProfiles(profiles);
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket
        .apiInfo(apiInfo())
        .enable(flag)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.erya.mall.controller"))
        //为有@Api注解的Controller生成API文档
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        //为有@ApiOperation注解的方法生成API文档
//        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .build().groupName("erya");
        return docket;
    }

    private Contact contact = new Contact("Mall", "https://www.baidu.com", "2424753284@qq.com");
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Comment Api信息",
                "Api 信息文档",
                "1.0",
                "组：dev",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }

}
