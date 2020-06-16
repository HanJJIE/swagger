package com.hanjj.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Swagger 配置类
 * 使用 @EnableSwagger2 启动 Swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.description}")
    private String description;

    @Bean
    public Docket docket(Environment environment) {

//        配置是否启动 Swagger，如果是 dev 或者 test 环境则启动
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .groupName("黄汉杰")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hanjj.swagger"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(RequestMapping.class))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    /**
     * 标题、版本号、作者信息等
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("黄汉杰", "https://hanjjie.github.io/", "1432345840@qq.com");
        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        return new ApiInfo(
                "汉杰杰的 API 文档",
                description,
                "v2.33",
                "https://hanjjie.github.io/",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                vendorExtensions
        );
    }
}