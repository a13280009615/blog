package com.zf.exception;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:35
 */
public class TagNotFoundException extends RuntimeException {

    public TagNotFoundException(){

    }

    public TagNotFoundException(String message){
        super(message);
    }
}
