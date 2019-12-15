package com.zf.repository;

import com.zf.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-14 下午 4:07
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment>  findByBlogIdAndParentCommentNull(Long id, Sort sort);

}
