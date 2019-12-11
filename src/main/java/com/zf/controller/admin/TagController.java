package com.zf.controller.admin;

import com.zf.pojo.Tag;
import com.zf.pojo.Type;
import com.zf.service.TagService;
import com.zf.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author zhengfan
 * @create 2019-12-12 上午 1:56
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     *  分类详情页
     * */
    @GetMapping("/tags")
    public String types(@PageableDefault(size = 3 ,sort = {"id"},direction = Sort.Direction.ASC) Pageable pageable,
                        Model model){

        model.addAttribute("page", tagService.listTag(pageable));

        return "admin/tags";
    }

    /**
     * url跳转分类新增
     * */
    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id , Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags-input";
    }



    /**
     * 新增分类
     * */
    @PostMapping("/tags")
    public  String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            result.rejectValue("name","nameError","该分类名称已经存在");
        }
        //加入后端验证
        if(result.hasErrors()){
            return "admin/tags-input";
        }

        Tag t = tagService.save(tag);
        if (t == null){
            //没有保存成功
            attributes.addFlashAttribute("message","操作失败");
        }else{
            attributes.addFlashAttribute("message","操作成功");
        }
        return  "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public  String editPost(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            result.rejectValue("name","nameError","该分类名称已经存在");
        }
        //加入后端验证
        if(result.hasErrors()){
            return "admin/tags-input";
        }

        Tag t = tagService.updateTag(id, tag);
        if (t == null){
            //没有保存成功
            attributes.addFlashAttribute("message","更新失败");
        }else{
            attributes.addFlashAttribute("message","更新成功");
        }
        return  "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id ,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return  "redirect:/admin/tags";

    }
}
