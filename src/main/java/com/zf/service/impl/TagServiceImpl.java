package com.zf.service.impl;

import com.zf.exception.TagNotFoundException;
import com.zf.pojo.Tag;
import com.zf.repository.TagRepository;
import com.zf.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-12 上午 1:58
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;
    @Override
    @Transactional
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    @Transactional
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag Tag) {
        Tag t = tagRepository.getOne(id);
        if (t == null){
            throw  new TagNotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(Tag,t);

        return  tagRepository.save(t);

    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
         tagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort  = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable =  PageRequest.of(0,size,sort);
        return tagRepository.findTop(pageable);
    }

    @Override
    public List<Tag> listTag(String ids) {
        List<Long> longList = convertToList(ids);

        return tagRepository.findAllById(longList);
    }
    private List<Long> convertToList(String ids){
      List<Long>  list = new ArrayList<>();
      if (!"".equals(ids) && ids != null){
          String [] idarray  =ids.split(",");
          for (int i = 0; i < idarray.length ; i++) {
              list.add(new Long(idarray[i]));
          }
      }
      return  list;
    }
}
