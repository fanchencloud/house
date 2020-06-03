package cn.fanchencloud.house.config;

import cn.fanchencloud.house.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 22:34
 * Description:
 *
 * @author chen
 */
@Configuration
public class FilterBeanConfig {
    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(10);
        filterRegistrationBean.addUrlPatterns("*");
        return filterRegistrationBean;

    }
}
