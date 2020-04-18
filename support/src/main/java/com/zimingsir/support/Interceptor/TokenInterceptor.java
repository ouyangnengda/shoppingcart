package com.zimingsir.support.Interceptor;

import com.zimingsir.support.pojo.Token;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 验证token是否有效的拦截器
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 18:38:00
 **/
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        Token token = getToken(cookies);
        if (token != null && token.getExpired() > System.currentTimeMillis()) {
            token = refresh(token);
            Cookie cookie = new Cookie("token", token.getExpired().toString());
            response.addCookie(cookie);
            return true;
        }
        return false;
    }

    /**
     * @Method：getToken
     * @Description: 获得cookie中的token
     * @param cookies
     * @return: com.zimingsir.support.pojo.Token
     * @Date: 2020/4/18 18:43
     */
    private Token getToken(Cookie[] cookies) {
        Token token = new Token();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token.setValue(cookie.getValue());
                token.setExpired(cookie.getMaxAge());
                break;
            }
        }
        return token;
    }

    /**
     * @Method：refresh
     * @Description: 刷新token的过期时间
     * @param token
     * @return: com.zimingsir.support.pojo.Token
     * @Date: 2020/4/18 18:09
     */
    private Token refresh(Token token) {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
