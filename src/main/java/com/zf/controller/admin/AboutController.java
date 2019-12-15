package com.zf.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhengfan
 * @create 2019-12-15 下午 3:08
 */
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
