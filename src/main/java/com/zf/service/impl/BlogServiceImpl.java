package com.zf.service.impl;

import com.zf.exception.BlogNotFoundException;
import com.zf.pojo.Blog;
import com.zf.pojo.Type;
import com.zf.repository.BlogRepository;
import com.zf.service.BlogService;
import com.zf.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog blog1 = blogRepository.getOne(id);
     if (blog1 == null){
            throw  new BlogNotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog1,blog);

        return blogRepository.save(blog1);
    }

    @Override
    public void deleteBlog(Long id) {
          blogRepository.deleteById(id);
    }
}
