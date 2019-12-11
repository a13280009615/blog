package com.zf.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 8:20
 * 博客分类
 */
@Data
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id ;

    @NotBlank(message = "分类名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
