package com.zf.service;

import com.zf.pojo.Comment;

import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-14 下午 4:05
 */
public interface CommentService {

    List<Comment>  listCommentByBlogId(Long id);

    Comment  saveComment(Comment comment);

}
