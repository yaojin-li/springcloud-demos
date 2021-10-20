package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description: --------------------------------------
 * @ClassName: RouteLocatorConfig.java
 * @Date: 2021/10/19 19:40
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Component
public class RouteLocatorConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        // 配置id为url-proxy-3的路由规则，访问 http://localhost:8010/about时，自动转发到http://www.ityouknow.com/about
        return builder.routes()
                .route("url-proxy-3", r -> r.path("/about").uri("http://www.ityouknow.com"))
                .build();
    }

}
