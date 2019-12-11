package com.zf.exception;

import jdk.nashorn.internal.ir.RuntimeNode;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 11:35
 */
public class TypeNotFoundException extends RuntimeException {

    public TypeNotFoundException(){

    }

    public TypeNotFoundException(String message){
        super(message);
    }
}
