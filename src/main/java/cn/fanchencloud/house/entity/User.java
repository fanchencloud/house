package cn.fanchencloud.house.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 22:34
 * Description:
 *
 * @author chen
 */
@Data
public class User {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 电子邮件地址
     */
    private String email;

    /**
     * 自我介绍
     */
    private String selfIntroduction;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户类别：1-普通用户，2-房产经纪人
     */
    private Integer type;

    /**
     * 是否启用：1-启用，0-禁用
     */
    private Integer enable;

    /**
     * 所属经济机构 默认值：0
     */
    private Integer agencyId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastEditTime;
}