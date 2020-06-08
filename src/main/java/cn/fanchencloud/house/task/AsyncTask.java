package cn.fanchencloud.house.task;

import cn.fanchencloud.house.util.MyStringUtils;
import cn.fanchencloud.house.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/7
 * Time: 17:32
 * Description: 异步执行任务
 *
 * @author chen
 */
@Component
public class AsyncTask {

    /**
     * 注入邮件发送
     */
    private JavaMailSender javaMailSender;

    /**
     * 注入模板引擎
     */
    private TemplateEngine emailTemplateEngine;

    /**
     * 注入邮件发送者
     */
    @Value("${spring.mail.username}")
    private String mailSender;

    /**
     * 注入网站基地址
     */
    @Value("${chen.baseWebSite}")
    private String baseWebSite;

    /**
     * 注入网站服务器端口
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * Redis 缓存过期时间
     */
    @Value("${chen.redis.expireTime:1800}")
    private int expireTime;

    /**
     * 注入Redis服务
     */
    private RedisUtil redisUtil;

    /**
     * 向用户发送激活邮件
     *
     * @param email 邮件地址
     */
    @Async
    public void registerActivationNotification(String email, String username) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom(mailSender);
        mimeMessageHelper.setTo(email);
        String universallyUniqueIdentifier = MyStringUtils.getUniversallyUniqueIdentifier();
        String registerActivationNotificationUrl = "/account/activation?username=" + username + "&code=" + universallyUniqueIdentifier;
        // 将用户名和随机生成的字符串放入Redis中
        redisUtil.setEx(username, universallyUniqueIdentifier, expireTime, TimeUnit.SECONDS);
        //thymeleaf模版解析成String
        Context ctx = new Context();
        ctx.setVariable("username", username);
        ctx.setVariable("validateLink", baseWebSite + ":" + serverPort + registerActivationNotificationUrl);
        ctx.setVariable("sendDate", new Date());
        String htmlContent = emailTemplateEngine.process("registerActivationNotification", ctx);
        mimeMessageHelper.setText(htmlContent, true);
        javaMailSender.send(message);
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    public void setEmailTemplateEngine(TemplateEngine emailTemplateEngine) {
        this.emailTemplateEngine = emailTemplateEngine;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }
}
