package com.example.demo.hystrix;

import com.example.demo.feign.ConsumerRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: --------------------------------------
 * @ClassName: ConsumerRemoteHystrix.java
 * @Date: 2021/10/4 21:19
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Component
public class ConsumerRemoteHystrix implements ConsumerRemote {

    @Override
    public String hello2(@RequestParam(value = "name") String name) {
        return "hello2" + name + ", this message send failed.[熔断]";
    }
}
