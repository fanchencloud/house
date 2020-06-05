package cn.fanchencloud.house.controller;

import cn.fanchencloud.house.entity.Agency;
import cn.fanchencloud.house.service.AgencyService;
import cn.fanchencloud.house.service.BlogService;
import cn.fanchencloud.house.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 注入房产经纪机构服务层
     */
    private AgencyService agencyService;

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
    @ResponseBody
    public String testError() {
        String message = "test";
        if (message != null) {
            throw new IllegalArgumentException();
        }
        return "test";
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("account/register");
        List<Agency> agencyList = agencyService.getAllAgency();
        modelAndView.addObject("agencyList", agencyList);
        return modelAndView;
    }

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @Autowired
    public void setAgencyService(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
}
