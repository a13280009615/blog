package com.zf.controller.admin;

import com.zf.pojo.Blog;
import com.zf.service.BlogService;
import com.zf.service.TypeService;
import com.zf.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:54
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;

    @GetMapping("/blogs")
    public String list(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model, BlogQuery blog){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable, blog));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model,BlogQuery blog){
        model.addAttribute("page",blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }
}
