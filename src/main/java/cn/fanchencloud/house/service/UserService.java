package cn.fanchencloud.house.service;

import cn.fanchencloud.house.model.UserModel;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 14:26
 * Description: 用户服务接口
 *
 * @author chen
 */
public interface UserService {
    /**
     * 添加一个用户
     *
     * @param userModel  用户信息
     * @param avatarFile 用户头像
     * @return 添加结果
     */
    boolean addAccount(UserModel userModel, MultipartFile avatarFile);
}
