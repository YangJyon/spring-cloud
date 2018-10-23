package com.jyon.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Jyon
 * @Date: 2018/10/21/021 20:05
 * @Description:
 */
public class PreZuulFilter extends ZuulFilter{

    private static  final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String remoteHost = request.getRemoteHost();
        LOGGER.info("请求的host：{}",remoteHost);
        return null;
    }
}
