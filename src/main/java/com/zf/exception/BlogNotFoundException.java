package com.zf.exception;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:35
 */
public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(){

    }

    public BlogNotFoundException(String message){
        super(message);
    }
}
