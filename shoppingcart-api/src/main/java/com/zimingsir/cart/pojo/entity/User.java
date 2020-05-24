package com.zimingsir.cart.pojo.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月22日 10:15:00
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String money;
    private String receiveAddress;
    private Integer createBy;
    private LocalDateTime createTime;
    private Integer updateBy;
    private LocalDateTime updateTime;
}
