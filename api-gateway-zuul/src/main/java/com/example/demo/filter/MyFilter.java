package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;


/**
 * @Description: --------------------------------------
 * @ClassName: MyFilter.java
 * @Date: 2021/10/12 19:41
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class MyFilter extends ZuulFilter {

    /**
     * 定义filter的类型，有pre、route、post、error四种
     * 可以在请求被路由之前调用
     * */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义filter的顺序，数字越小表示顺序越高，越先执行
     * */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 表示是否需要执行该filter，true表示执行，false表示不执行
     * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter需要执行的具体操作
     * */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
