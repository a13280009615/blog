package com.zf.service.impl;

import com.zf.pojo.PersonInfo;
import com.zf.repository.PersonInfoRepository;
import com.zf.service.PersonInfoService;
import com.zf.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:10
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoRepository personInfoRepository;

    @Override
    public PersonInfo checkUser(String username, String password) {

        PersonInfo personInfo = personInfoRepository.findByUsernameAndPassword(username, MD5Util.code(password));
        return personInfo;
    }
}
