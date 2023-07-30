package com.cpj.snippet.filter;

import cn.hutool.core.util.URLUtil;
import com.cpj.snippet.util.HttpHelper;
import com.cpj.snippet.warpper.BodyReaderHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 不知道你有没有用过Enable开头的注解，比如：EnableAsync、EnableCaching、EnableAspectJAutoProxy等，
 * 这类注解就像开关一样，只要在@Configuration定义的配置类上加上这类注解，就能开启相关的功能。
 * <p>
 * 是不是很酷？
 * <p>
 * 让我们一起实现一个自己的开关：
 * <p>
 * 第一步，定义一个LogFilter
 *
 * @author chenpeijian
 * @date 2023/2/15 21:13
 */
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper =  new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
        HttpServletRequest req = (HttpServletRequest) request;
        String requestUri = URLUtil.getPath(req.getRequestURI());
        String bodyString = HttpHelper.getBodyString(requestWrapper);
        log.info("入参为：{}", req.getQueryString());
        log.info("requestUri：{}",requestUri);
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        log.info(String.format("响应耗时:%d",System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {

    }
}