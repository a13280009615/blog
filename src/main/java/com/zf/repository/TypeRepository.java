package com.zf.repository;

import com.zf.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:31
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
