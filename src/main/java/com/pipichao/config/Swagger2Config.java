package com.pipichao.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pipichao"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("欢迎到我的GitHub：https://github.com/shift2C1/")
                .termsOfServiceUrl("https://github.com/shift2C1/")
                .contact("王超")
                .version("1.0")
                .build();
    }

    /**
     * 使用fastjson 的消息转换器
     * 不用默认的jackson
     *
     * */
    @Bean
    public FastJsonHttpMessageConverter messageConverter(){
        return new FastJsonHttpMessageConverter();
    }
}
