package cn.fanchencloud.house.service.impl;

import cn.fanchencloud.house.config.ImageConfig;
import cn.fanchencloud.house.dao.UserMapper;
import cn.fanchencloud.house.entity.User;
import cn.fanchencloud.house.model.UserModel;
import cn.fanchencloud.house.service.UserService;
import cn.fanchencloud.house.system.service.FileService;
import cn.fanchencloud.house.task.AsyncTask;
import cn.fanchencloud.house.util.BeanHelper;
import cn.fanchencloud.house.util.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 14:26
 * Description:
 *
 * @author chen
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * 注入文件服务类
     */
    private FileService fileService;

    /**
     * 注入用户数据持久层
     */
    private UserMapper userMapper;

    /**
     * 注入异步任务
     */
    private AsyncTask asyncTask;

    /**
     * 1 - 用户密码进行加密
     * 2- 用户信息存入数据库
     * 3- 保存用户头像
     * 4- 生成随机key，向用户发送激活邮件
     *
     * @param userModel  用户信息
     * @param avatarFile 用户头像
     * @return 操作结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addAccount(UserModel userModel, MultipartFile avatarFile) {
        BeanHelper.setDefaultProp(userModel, User.class);
        BeanHelper.onInsert(userModel);
        userModel.setEnable(0);
        userModel.setPassword(MyStringUtils.encryptToMD5(userModel.getPassword()));
        // 保存用户头像
        if (avatarFile != null) {
            String image = fileService.saveImage(avatarFile, ImageConfig.IMAGE_USER_AVATAR_INDEX, null);
            userModel.setAvatar(image);
        }
        // 将用户数据持久化到数据库
        if (userMapper.addUser(userModel) == 0) {
            return false;
        }
        // 发送邮件
        try {
            asyncTask.registerActivationNotification(userModel.getEmail(), userModel.getUsername());
        } catch (MessagingException e) {
            log.error("发送邮件出错");
            e.printStackTrace();
        }
        return true;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setAsyncTask(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }
}
