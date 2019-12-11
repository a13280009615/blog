package com.zf.repository;

import com.zf.pojo.Tag;
import com.zf.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhengfan
 * @create 2019-12-12 上午 1:59
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
