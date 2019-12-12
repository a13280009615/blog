package com.zf.vo;

import lombok.Data;

/**
 * @author zhengfan
 * @create 2019-12-12 下午 3:59
 */
@Data
public class BlogQuery {

    private String title;

    private  Long  typeId ;

    private boolean recommend;

}
