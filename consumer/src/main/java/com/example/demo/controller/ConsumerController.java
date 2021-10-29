    package com.example.demo.controller;

    import com.example.demo.feign.ConsumerRemote;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.rmi.Remote;

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
    public class ConsumerController {

        @Autowired
        ConsumerRemote remote;

        @RequestMapping("/hello2/{name}")
        public String index(@PathVariable("name") String name) {
            return remote.hello2(name);
        }

    }