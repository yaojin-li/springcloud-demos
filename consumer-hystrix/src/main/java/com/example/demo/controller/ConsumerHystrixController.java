package com.example.demo.controller;

import com.example.demo.feign.HelloRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: --------------------------------------
 * @ClassName: ConsumerController.java
 * @Date: 2021/9/30 17:03
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@RestController
public class ConsumerHystrixController {

    @Autowired
    HelloRemote HelloRemote;

    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "fall")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name);
    }

    public String fall() {
        return "fall back ...";
    }
}