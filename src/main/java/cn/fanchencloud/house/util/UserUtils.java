package cn.fanchencloud.house.util;

import cn.fanchencloud.house.model.ResultMessage;
import cn.fanchencloud.house.model.UserModel;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 20:23
 * Description: 用户工具类
 *
 * @author chen
 */
public class UserUtils {

    public static ResultMessage validateUser(UserModel userModel) {
        if (StringUtils.isBlank(userModel.getUsername())) {
            return ResultMessage.errorMessage("用户名不能为空！");
        }
        if (StringUtils.isBlank(userModel.getEmail())) {
            return ResultMessage.errorMessage("Email 不能为空！");
        }
        if (StringUtils.isBlank(userModel.getPassword())) {
            return ResultMessage.errorMessage("密码不能为空！");
        }
        if (StringUtils.isBlank(userModel.getConfirmPassword())) {
            return ResultMessage.errorMessage("确认密码不能为空！");
        }
        if (!StringUtils.equals(userModel.getPassword(), userModel.getConfirmPassword())) {
            return ResultMessage.errorMessage("两次密码不一致！");
        }
        if (StringUtils.isBlank(userModel.getUsername())) {
            return ResultMessage.errorMessage("用户名不能为空！");
        }
        return ResultMessage.successMessage("");
    }

}
