package com.zf.controller.admin;

import com.zf.pojo.PersonInfo;
import com.zf.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:14
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    PersonInfoService personInfoService;

    @GetMapping
    public String login(){
        return "admin/login";
    }

    @PostMapping("/login")
    public  String personInfoLogin(@RequestParam String username ,
                                   @RequestParam String password,
                                   HttpSession session,
                                   RedirectAttributes attributes){

        PersonInfo personInfo = personInfoService.checkUser(username, password);
        if (personInfo != null){
            //查找到用户了
            personInfo.setPassword(null);
            session.setAttribute("personInfo",personInfo);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return  "redirect:admin/login";
        }
    }


    @GetMapping("/login")
    public String loginIndex(HttpSession session){
        PersonInfo personInfo = (PersonInfo) session.getAttribute("personInfo");
        if(personInfo == null){
            return "admin/login";
        }else {
            return "admin/index";
        }
    }


    @GetMapping("/logout")
    public  String loginOut(HttpSession session){
        session.removeAttribute("personInfo");
        return  "redirect:/admin";
    }
}
