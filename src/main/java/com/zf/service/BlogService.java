package com.zf.service;

import com.zf.pojo.Blog;
import com.zf.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author zhengfan
 * @create 2019-12-12 下午 2:22
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable , BlogQuery blog);

    Blog saveBlog(Blog blog);
    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    Blog updateBlog(Long id ,Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Map<String ,List<Blog>> archivesBlog();

    Long countBlog();
}
