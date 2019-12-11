package com.zf.service;

import com.zf.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:28
 */
public interface TypeService {

    Type save(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id , Type type);

    void deleteType(Long id);

    Type getTypeByName(String name);
}
