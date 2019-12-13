package com.zf.repository;

import com.zf.pojo.Tag;
import com.zf.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-12 上午 1:59
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select  t  from Tag  t")
    List<Tag> findTop(Pageable pageable);
}
