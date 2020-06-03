package cn.fanchencloud.house.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 22:30
 * Description: 日志过滤器
 *
 * @author chen
 */
public class LogFilter implements Filter {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Request-- coming");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
