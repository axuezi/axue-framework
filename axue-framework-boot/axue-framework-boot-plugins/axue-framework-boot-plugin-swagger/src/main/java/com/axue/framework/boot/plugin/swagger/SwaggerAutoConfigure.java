package com.axue.framework.boot.plugin.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * @author axue
 */
@Configuration
@EnableSwagger2
// 将配置属性类注入到spring容器中
@EnableConfigurationProperties(SwaggerAutoConfigProperties.class)
public class SwaggerAutoConfigure {

    @Resource
    private SwaggerAutoConfigProperties swaggerAutoConfigProperties;

    // 只有在spring容器中没有这个bean的时候才会注册,如果有则不注册
    @Bean
    @ConditionalOnMissingBean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            // 这里配置swagger扫描哪个包
            .apis(RequestHandlerSelectors.basePackage(swaggerAutoConfigProperties.getScanPackage()))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(swaggerAutoConfigProperties.getTitle())// 文档标题
            .build();
    }
}
