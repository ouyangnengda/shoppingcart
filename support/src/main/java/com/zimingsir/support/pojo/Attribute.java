package com.zimingsir.support.pojo;

import java.util.List;
import lombok.Data;

/**
 * @Description:
 * @Author: 欧阳能达
 * @Created: 2020年05月07日 17:01:00
 **/
@Data
public class Attribute {
    private String attributeName;
    private List<Value> values;
}
