package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: --------------------------------------
 * @ClassName: HelloController.java
 * @Date: 2021/9/30 15:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello " + name + "，this is first messge";
    }

    @RequestMapping("/hello2")
    public String index2(@RequestParam String name) {
        return "hello2 " + name + "，this is first messge";
    }

    @RequestMapping("/helloZuul")
    public String helloZuul(@RequestParam String name) {
        return "helloZuul " + name + "，this is first messge";
    }

    @RequestMapping("/zuulToken")
    public String zuulToken(@RequestParam String name) {
        return "zuulToken " + name + "，this is first messge";
    }

    @RequestMapping("/zuulRetry")
    public String zuulRetry(@RequestParam String name) {
        logger.info("request is:" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "zuulRetry " + name + "，this is first messge";
    }

}