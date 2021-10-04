package com.example.demo.hystrix;

import com.example.demo.feign.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: --------------------------------------
 * @ClassName: HelloRemoteHystrix.java
 * @Date: 2021/10/4 21:19
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello" + name + ", this message send failed.[熔断]";
    }
}
