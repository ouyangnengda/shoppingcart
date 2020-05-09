package com.zimingsir.support.service.Impl;

import com.zimingsir.support.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 20:38:00
 **/
@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    /*final TokenDAO tokenDAO;

    public TokenServiceImpl(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

    @Override
    public Token getToken(HttpServletRequest request) {
        if (request != null) {
            Cookie[] cookies = request.getCookies();
            Optional<Token> token = Optional.ofNullable(getToken(cookies));
            if (token.isPresent()) {
                return token.get();
            }
        }
        return null;
    }

    private Token getToken(Cookie[] cookies) {
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName()) && cookie.getValue() != null) {
                    Token token = tokenDAO.getToken(cookie.getValue());
                    // TODO 通过value到数据库查询得到expired
                    if (token != null) {
                        return token;
                    }
                }
            }
        }
        return null;
    }

    *//**
     * @param token
     * @Method：refresh
     * @Description: 刷新传进来tonken的过期时间
     * @return: com.zimingsir.support.pojo.Token
     * @Date: 2020/4/19 11:12
     *//*
    @Override
    public boolean refresh(Token token) {
        if (token != null && token.getValue() != null) {
            // TODO 通过dao设置token的过期时刻
            token.setExpired(System.currentTimeMillis() + VariableUtil.TOKEN_LIVE_TIME);
            return tokenDAO.setTokenByValue(token, token.getValue());
        }
        return false;
    }*/

    // @Override
    // public Integer getUserIdFromRequest(HttpServletRequest request) {
    //     Optional<Token> token = Optional.ofNullable(getToken(request));
    //     if (token.isPresent()) {
    //         Integer userId = getUserId(token.get());
    //
    //     }
    //     return 0;
    // }

    /**
     * @Method：isEffective
     * @Description: 如果token里面的expired有值，那就用里面的值来比较；如果没值，那就去数据库里面查到expired，再来比较。
     * @param token
     * @return: boolean
     * @Date: 2020/4/19 8:34
     */
    /*private boolean isEffective(Token token) {
        if (token != null ) {
            if (token.getExpired() == null) {
                // TODO 使用token的value去数据库查询，得到expired
                // TODO cookie的单位是秒，maxAge表示的是生存的时间
            }


        }
        return false;
    }

    @Override
    public Integer getUserId(Token token) {

        // TODO 这里要通过数据库查询得到id
        return 0;
    }*/
}
