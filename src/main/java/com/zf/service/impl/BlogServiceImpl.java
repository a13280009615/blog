package com.zf.service.impl;

import com.zf.exception.BlogNotFoundException;
import com.zf.pojo.Blog;
import com.zf.pojo.Type;
import com.zf.repository.BlogRepository;
import com.zf.service.BlogService;
import com.zf.utils.MarkdownUtils;
import com.zf.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * @author zhengfan
 * @create 2019-12-12 下午 2:24
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
     private BlogRepository blogRepository;
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate>  predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) &&blog.getTitle() !=null){
                    predicates.add(criteriaBuilder.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                if (blog.getTypeId()  != null){
                    predicates.add(criteriaBuilder.equal(root.<Type>get("type").get("id"),blog.getTypeId()));
                }
                if (blog.isRecommend()){
                     predicates.add(criteriaBuilder.equal(root.<Boolean>get("recommend"),blog.isRecommend()));
                }
                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

                return null;
            }
        }  ,pageable);
    }

    @Override
    @Transactional
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        }else {
            blog.setUpdateTime(new Date());
        }

        return blogRepository.save(blog);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findByQuery(query,pageable);
    }

    @Override
    @Transactional
    public Blog updateBlog(Long id, Blog blog) {
        Blog blog1 = blogRepository.getOne(id);
     if (blog1 == null){
            throw  new BlogNotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog,blog1);
        if (blog1.getViews() == null){
            blog1.setViews(0);
        }

         blog1.setUpdateTime(new Date());
        return blogRepository.save(blog1);
    }

    @Override
    @Transactional
    public void deleteBlog(Long id) {
          blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        Sort sort  = Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable =  PageRequest.of(0,size,sort);
        return blogRepository.findTop(pageable);
    }

    @Override
    @Transactional
    public Blog getAndConvert(Long id) {
        Blog blog  =blogRepository.getOne(id);
        if (blog == null) {
            throw  new BlogNotFoundException("博客不存在");
        }
        Blog blog1 = new Blog();
        BeanUtils.copyProperties(blog,blog1);
        String content = blog1.getContent().replace("#","");

        blog1.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogRepository.updateViews(id);
        return blog1;
    }

    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join join =root.join("tags");
                return criteriaBuilder.equal(join.get("id"),tagId);
            }
        },pageable);
    }

    @Override
    public Map<String, List<Blog>> archivesBlog() {
        List<String> years =blogRepository.findGroupYear();
        Map<String,List<Blog>> map = new HashMap<>();
        for (String year : years){
               map.put(year,blogRepository.findByYear(year));
        }
        return map;
    }

    @Override
    public Long countBlog() {
        return blogRepository.count();
    }
}
