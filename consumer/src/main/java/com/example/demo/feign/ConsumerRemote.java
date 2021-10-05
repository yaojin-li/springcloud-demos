package com.example.demo.feign;

import com.example.demo.hystrix.ConsumerRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: --------------------------------------
 * @ClassName: ConsumerRemote.java
 * @Date: 2021/9/30 17:04
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@FeignClient(name = "spring-cloud-producer", fallback = ConsumerRemoteHystrix.class)
public interface ConsumerRemote {
    @RequestMapping(value = "/hello2")
    String hello2(@RequestParam(value = "name") String name);
}