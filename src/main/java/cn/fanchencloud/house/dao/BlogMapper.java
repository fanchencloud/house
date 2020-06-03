package cn.fanchencloud.house.dao;

import cn.fanchencloud.house.entity.Blog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 22:34
 * Description: 百科表数据持久化操作
 *
 * @author chen
 */
@Mapper
public interface BlogMapper {
    /**
     * 查询所有的百科信息
     *
     * @return 百科列表
     */
    List<Blog> queryAllBlog();
}