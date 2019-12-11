package com.zf.service.impl;


import com.zf.exception.TypeNotFoundException;
import com.zf.pojo.Type;
import com.zf.repository.TypeRepository;
import com.zf.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:30
 */
@Service
public class TypeServiceImpl implements TypeService {

   @Autowired
   private TypeRepository typeRepository;

    @Override
    @Transactional
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type getType(Long id) {
        return typeRepository.getOne(id);
    }

    @Override
    @Transactional
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        Type t  = typeRepository.getOne(id);
        if (t == null){
            throw  new TypeNotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);

        return  typeRepository.save(t);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }
}
