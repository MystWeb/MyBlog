package com.proaim.blog.website.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
// @ConditionalOnExpression注解，用户是否实例化本类，用于是否启用Swagger的判断（生产环境需要屏蔽Swagger）
@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfig {
    @Bean
    public Docket createDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Shop API")
                        .description("Shop 相关接口API文档")
                        .version("1.0").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.proaim.myblog.website.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
