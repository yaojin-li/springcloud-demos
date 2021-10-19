package com.example.demo.controller;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @Description: --------------------------------------
 * @ClassName: ServiceController.java
 * @Date: 2021/10/20 19:09
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@RestController
public class ServiceController {
    Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * 获取所有服务
     * consul-service-producer 为 producer 注册到consul的服务名称。
     * 一个producer集群可以配置同一个服务名称注册到consul中被消费。
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("consul-service-producer");
    }

    /**
     * 从所有服务中选择一个服务（轮训）
     * 实现获取服务端地址的均衡负载
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("consul-service-producer").getUri().toString();
    }


}
