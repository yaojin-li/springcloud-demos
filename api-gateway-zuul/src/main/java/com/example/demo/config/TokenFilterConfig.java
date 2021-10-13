package com.example.demo.config;

import com.example.demo.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description: --------------------------------------
 * @ClassName: TokenFilterConfig.java
 * @Date: 2021/10/14 20:33
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@Component
public class TokenFilterConfig {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
