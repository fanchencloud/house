package cn.fanchencloud.house.controller;

import cn.fanchencloud.house.entity.Blog;
import cn.fanchencloud.house.service.BlogService;
import cn.fanchencloud.house.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 23:43
 * Description:
 *
 * @author chen
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    /**
     * 注入百科信息服务层
     */
    private BlogService blogService;

    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @GetMapping("/test")
    public Map<String, Object> test() {
        List<Blog> blogList = blogService.queryAllBlog();
        Map<String, Object> map = new HashMap<>(4);
        map.put("message", "test message");
        map.put("blogList", blogList);
        return map;
    }

    @GetMapping("/testError")
    public ModelAndView testError() {
        ModelAndView modelAndView = new ModelAndView("registerActivationNotification");
        redisUtil.set("test", "hello");
        String username = redisUtil.get("fanchencloud");
        redisUtil.setEx("time1", "test time1", 30, TimeUnit.MILLISECONDS);
        modelAndView.addObject("username", username);
        modelAndView.addObject("validateLink", "http://www.baidu.com");
        modelAndView.addObject("sendDate", new Date());
        return modelAndView;
    }

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }
}
