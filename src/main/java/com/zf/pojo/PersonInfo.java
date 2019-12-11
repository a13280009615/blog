package com.zf.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 8:27
 */
@Data
@Entity
@Table(name = "t_personInfo")
public class PersonInfo {

    @Id
    @GeneratedValue
    private Long id ;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany(mappedBy = "personInfo")
    private List<Blog> blogs = new ArrayList<>();
}
