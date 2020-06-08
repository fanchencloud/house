package cn.fanchencloud.house.controller;

import cn.fanchencloud.house.entity.Agency;
import cn.fanchencloud.house.model.ResultMessage;
import cn.fanchencloud.house.model.UserModel;
import cn.fanchencloud.house.service.AgencyService;
import cn.fanchencloud.house.service.UserService;
import cn.fanchencloud.house.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 14:26
 * Description: 用户控制器
 *
 * @author chen
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 注入用户服务
     */
    private UserService userService;


    /**
     * 注入房产经纪机构服务层
     */
    private AgencyService agencyService;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView("account/register");
        List<Agency> agencyList = agencyService.getAllAgency();
        modelAndView.addObject("agencyList", agencyList);
        return modelAndView;
    }


//    @PostMapping(value = "/register")
//    public ModelAndView register(HttpServletRequest request,
//                                 @RequestParam("type") Integer type,
//                                 @RequestParam(value = "agencyId", required = false) Integer agencyId,
//                                 @RequestParam("username") String username,
//                                 @RequestParam("email") String email,
//                                 @RequestParam("phone") String verifyCode,
//                                 @RequestParam("verifyCode") String verifyCode,
//                                 @RequestParam("verifyCode") String verifyCode,
//                                 @RequestParam("verifyCode") String verifyCode,
//                                 @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail) {
//
//        return null;
//    }

    @PostMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request, UserModel userModel,
                                 @RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile) {
        logger.info("用户信息：" + userModel.toString());
        ModelAndView modelAndView = new ModelAndView("account/register");
        ResultMessage resultMessage = UserUtils.validateUser(userModel);
        if (resultMessage.isSuccess()) {
            if (userService.addAccount(userModel, avatarFile)) {
                modelAndView.addObject(ResultMessage.SUCCESS_MESSAGE_KEY, "注册成功，请返回登录！");
            } else {
                modelAndView.addObject(ResultMessage.ERROR_MESSAGE_KEY, "注册失败");
            }
        } else {
            modelAndView.addObject(ResultMessage.ERROR_MESSAGE_KEY, resultMessage.getErrorMessage());
        }
        return modelAndView;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAgencyService(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
}
