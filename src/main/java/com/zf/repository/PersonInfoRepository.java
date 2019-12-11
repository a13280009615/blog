package com.zf.repository;

import com.zf.pojo.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:11
 */
public interface PersonInfoRepository extends JpaRepository<PersonInfo,Long> {

    PersonInfo findByUsernameAndPassword(String username,String password);
}
