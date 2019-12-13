package com.zf.service;

import com.zf.pojo.Tag;
import com.zf.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-12 上午 1:57
 */
public interface TagService {
    Tag save(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id , Tag Tag);

    void deleteTag(Long id);

    Tag getTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);
}
