package com.example.demo.controller;

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


}