package com.zf.controller;

import com.zf.service.BlogService;
import com.zf.service.TagService;
import com.zf.service.TypeService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhengfan
 * @create 2019-12-13 下午 7:46
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
     public  String index(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                          Model model){
      model.addAttribute("page",blogService.listBlog(pageable));
      model.addAttribute("types",typeService.listTypeTop(6));
      model.addAttribute("tags",tagService.listTagTop(3));
      model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));
        return  "index";
     }

     @PostMapping("/search")
     public  String search(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                           @RequestParam String query, Model model){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
         return "search";
     }

     @GetMapping("/blog/{id}")
     public  String blog(@PathVariable Long id, Model model){
         model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
     }


     @GetMapping("/footer/newblog")
     public String newBlogs(Model model){
        model.addAttribute("newBlogs",blogService.listRecommendBlogTop(3));
        return "_fragments :: newBlogList";
     }
}
