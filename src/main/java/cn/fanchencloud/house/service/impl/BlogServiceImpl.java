package cn.fanchencloud.house.service.impl;

import cn.fanchencloud.house.dao.BlogMapper;
import cn.fanchencloud.house.service.BlogService;
import cn.fanchencloud.house.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/3
 * Time: 14:31
 * Description:
 *
 * @author chen
 */
@Service
public class BlogServiceImpl implements BlogService {

    /**
     * 注入百科信息持久层
     */
    private BlogMapper blogMapper;

    @Override
    public List<Blog> queryAllBlog() {
        return blogMapper.queryAllBlog();
    }

    @Autowired
    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }
}
