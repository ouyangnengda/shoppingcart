package com.zimingsir.support.dao;

import com.zimingsir.support.pojo.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 关于token的数据库查询
 * @Author: 欧阳能达
 * @Created: 2020年04月19日 08:55:00
 **/
@Repository
public interface TokenDAO {
    Token getToken(String value);
    boolean setTokenByValue(@Param("token")Token token, @Param("value") String value);
}
