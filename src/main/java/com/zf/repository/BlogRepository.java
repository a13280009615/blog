package com.zf.repository;

import com.zf.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-12 下午 2:24
 */
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select  b from  Blog  b where  b.recommend = true ")
    List<Blog> findTop(Pageable pageable);

    @Query("select  b from  Blog b where  b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query,Pageable pageable);
}
