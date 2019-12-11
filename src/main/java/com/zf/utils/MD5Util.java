package com.zf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:44
 */
public class MD5Util {

    public  static String code(String str){
       try{
           MessageDigest md =MessageDigest.getInstance("MD5");
           md.update(str.getBytes());
           byte [] byteDigest = md.digest();
           int i ;
           StringBuffer buf = new StringBuffer("");
           for (int offset = 0 ; offset <byteDigest.length;offset++){
               i = byteDigest[offset];
               if (i < 0){
                   i += 256;
               }
               if(i < 16){
                   buf.append("0");
               }
               buf.append(Integer.toHexString(i));
           }
           return  buf.toString();

       }catch (NoSuchAlgorithmException e){
           e.printStackTrace();
           return null;
       }

    }


}
