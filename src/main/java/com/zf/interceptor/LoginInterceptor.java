package com.zf.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengfan
 * @create 2019-12-11 下午 10:59
 * 自定义拦截器 不能直接访问地址 进入 不安全
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("personInfo") == null){
            response.sendRedirect("/admin");
            return  false;
        }
        return true;
    }
}
