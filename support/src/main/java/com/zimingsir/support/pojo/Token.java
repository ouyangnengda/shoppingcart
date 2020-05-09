package com.zimingsir.support.pojo;

import lombok.Data;

/**
 * @Description: Token的pojo类
 * @Author: 欧阳能达
 * @Created: 2020年04月18日 17:40:00
 **/
@Data
public class Token {
    private String value;
    private Long expired;
    private Integer userId;

}
