package cn.fanchencloud.house.model;

import cn.fanchencloud.house.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 14:46
 * Description:
 *
 * @author chen
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserModel extends User {
    /**
     * 确认密码
     */
    private String confirmPassword;
}
