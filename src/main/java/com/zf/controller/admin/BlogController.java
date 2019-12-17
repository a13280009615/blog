package com.zf.controller.admin;

import com.zf.pojo.Blog;
import com.zf.pojo.PersonInfo;
import com.zf.service.BlogService;
import com.zf.service.TagService;
import com.zf.service.TypeService;
import com.zf.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
    @Autowired
    TagService tagService;

    @GetMapping("/blogs")
    public String list(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model, BlogQuery blog){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable, blog));
        return "admin/blogs";
    }

    /**
     * 查询的时候   配合 thymeleaf模板引擎 实现局部刷新
     * */
    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model,BlogQuery blog){
        model.addAttribute("page",blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        return "admin/blogs-input";
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        Blog blog =blogService.getBlog(id);
         blog.init();
        model.addAttribute("blog", blog);
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        return "admin/blogs-input";
    }




    @PostMapping("/blogs")
    public  String post(Blog blog, HttpSession session, RedirectAttributes attributes){
        blog.setPersonInfo((PersonInfo) session.getAttribute("personInfo"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog saveBlog = null ;
        if (blog.getId() == null){
            saveBlog = blogService.saveBlog(blog);
        }else {
            saveBlog =blogService.updateBlog(blog.getId(),blog);
        }

        if (saveBlog != null){
            attributes.addFlashAttribute("message","操作成功");

        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blogs";

    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id ,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
           return  "redirect:/admin/blogs";
    }
}
