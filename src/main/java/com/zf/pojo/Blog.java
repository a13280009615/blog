package com.zf.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 8:11
 */
@Data
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
   //内容
    private  String content;
   //首图
    private String firstPicture;
   //标签
    private String flag;

     // 游览次数
    private Integer views;

     // 是否开启 赞赏
    private boolean appreciation;
     // 是否开启分享
    private boolean shareStatement;
    // 是否开启评论
    private boolean commentabled;
    // 是否发布
    private boolean published;
    //是否推荐
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date  createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private PersonInfo personInfo;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
}
