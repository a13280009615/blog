package com.zf.controller;

import com.zf.pojo.Tag;
import com.zf.pojo.Type;
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

import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-14 下午 9:58
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService TagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("tags/{id}")
    public String types(@PageableDefault(size = 10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model){

        List<Tag> tags = TagService.listTagTop(10000);
       if (id == -1){
            id = tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTypeId",id);
        return  "tags";
    }

}
