package com.isoft.intercepter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterCepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        if ("/user/login.do".equals(url)) {
            return true;
        } else {
            String username = (String) request.getSession().getAttribute("userid");
            if (username == null) {
                /*如果是AJAX请求，则值为XMLHttpRequest*/
                String type=request.getHeader("X-Requested-With")==null ? "" : request.getHeader("X-Requested-With");
                //未登录
                if("XMLHttpRequest".equals(type)) {
                    //处理AJAX请求，设置响应头信息
                    response.setHeader("REDIRECT", "REDIRECT");
                    /*需要跳转页面的URL*/
                    System.out.println("aaaa");
                    response.setHeader("CONTEXTPATH", request.getContextPath()+"index.html");
                }
                else {
                    response.sendRedirect(request.getContextPath()+"index.html");
                }

                return false;
            } else
                return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
