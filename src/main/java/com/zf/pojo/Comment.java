package com.zf.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 8:23
 *  评论类
 */
@Data
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String email;

    private String content;

    //头像
    private  String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne()
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments;

    @ManyToOne
    private  Comment parentComment;


    @Column(columnDefinition = "false")
    private boolean adminComment;


}
