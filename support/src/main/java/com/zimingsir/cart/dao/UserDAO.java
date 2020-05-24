package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月22日 10:14:00
 **/
@Repository
public interface UserDAO {
    User get(Integer userId);
}
