package com.zf.service;

import com.zf.pojo.PersonInfo;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:09
 */
public interface PersonInfoService {

    PersonInfo checkUser(String username,String password);
}
