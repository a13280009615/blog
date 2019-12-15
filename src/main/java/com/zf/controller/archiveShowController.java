package com.zf.controller;

import com.zf.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhengfan
 * @create 2019-12-15 下午 2:35
 */
@Controller
public class archiveShowController {

    @Autowired
    BlogService blogService;

    @GetMapping("/archives")
    public  String archives(Model model){
        model.addAttribute("archiveMap",blogService.archivesBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }
}
