package com.zimingsir.support.Interceptor;

import com.zimingsir.support.pojo.Token;
import com.zimingsir.support.service.TokenService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 验证token是否有效的拦截器
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 18:38:00
 **/
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*Token token = tokenService.getToken(request);
        // TODO cookie的单位是秒，maxAge表示生存时长
        if (token != null && token.getExpired() > System.currentTimeMillis()) {
            token = refresh(token);
            // TODO cookie的单位是秒，maxAge表示生存时长
            Cookie cookie = new Cookie("token", token.getExpired().toString());
            response.addCookie(cookie);
            return true;
        }
        return false;*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
