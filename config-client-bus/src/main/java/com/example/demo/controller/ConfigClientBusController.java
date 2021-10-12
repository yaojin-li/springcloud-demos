package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: --------------------------------------
 * @ClassName: ConfigClientBusController.java
 * @Date: 2021/10/7 11:21
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@RestController
/**
 * 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
 */
@RefreshScope
public class ConfigClientBusController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${spring.application.name}")
    private String springApplicationName;

    @GetMapping("/config")
    public Object config() {
        return this.configInfo + "-====-" + this.springApplicationName;
    }
}
