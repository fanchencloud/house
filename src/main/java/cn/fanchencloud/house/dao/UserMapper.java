package cn.fanchencloud.house.dao;

import cn.fanchencloud.house.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 22:34
 * Description:
 *
 * @author chen
 */
@Mapper
public interface UserMapper {
    /**
     * 建一个用户信息持久化到数据库
     *
     * @param user 用户信息
     * @return 持久胡影响记录条数
     */
    int addUser(User user);
}