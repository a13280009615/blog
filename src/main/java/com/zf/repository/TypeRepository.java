package com.zf.repository;

import com.zf.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:31
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from  Type t ")
    List<Type>  findTop(Pageable pageable);
}
