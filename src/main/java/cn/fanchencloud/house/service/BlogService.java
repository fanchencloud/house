package cn.fanchencloud.house.service;

import cn.fanchencloud.house.entity.Blog;

import java.util.List;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/3
 * Time: 14:30
 * Description:
 *
 * @author chen
 */
public interface BlogService {
    /**
     * 查询所有的百科信息
     *
     * @return 百科列表
     */
    List<Blog> queryAllBlog();
}
