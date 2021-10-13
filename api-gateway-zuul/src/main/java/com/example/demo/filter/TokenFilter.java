package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: --------------------------------------
 * @ClassName: TokenFilter.java
 * @Date: 2021/10/12 20:12
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TokenFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 定义filter的类型，有pre、route、post、error四种
     * 可以在请求被路由之前调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义filter的顺序，数字越小表示顺序越高，越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示是否需要执行该filter，true表示执行，false表示不执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter需要执行的具体操作
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("TokenFilter 执行 [%s] [%s]",
                request.getMethod(), request.getRequestURL().toString()));

        // 只针对指定的接口限制
        String reqUrl = request.getRequestURL().toString();
        String token = request.getParameter("token");
        if (reqUrl.contains("zuulToken")){
            if (StringUtils.isNotBlank(token)) {
                // 对请求进行路由
                context.setResponseStatusCode(200);
                context.setSendZuulResponse(true);
                context.set("isSuccess", true);
                logger.info(String.format("请求路由正常，路由地址[%s]", reqUrl));
            } else {
                // 不对其进行路由
                context.setResponseStatusCode(400);
                context.setResponseBody("token is empty");
                context.set("isSuccess", false);
                logger.info(String.format("请求路由拦截[token为空]，路由地址[%s]", reqUrl));
            }
        }
        return null;
    }

}
