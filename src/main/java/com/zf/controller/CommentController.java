package com.zf.controller;

import com.zf.pojo.Comment;
import com.zf.pojo.PersonInfo;
import com.zf.service.BlogService;
import com.zf.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zhengfan
 * @create 2019-12-14 下午 4:00
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public  String commentList(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return  "blog :: commentList";
    }

    @PostMapping("/comments")
    public  String post(Comment comment, HttpSession session){
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        PersonInfo personInfo = (PersonInfo) session.getAttribute("personInfo");
        if (personInfo != null){
            comment.setAvatar(personInfo.getAvatar());
            comment.setAdminComment(true);

        }else {
            comment.setAvatar(avatar);
            comment.setAdminComment(false);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" +  blogId;
    }
}
