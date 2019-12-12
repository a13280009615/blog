package com.zf.service;

import com.zf.pojo.Blog;
import com.zf.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zhengfan
 * @create 2019-12-12 下午 2:22
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable , BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id ,Blog blog);

    void deleteBlog(Long id);
}
