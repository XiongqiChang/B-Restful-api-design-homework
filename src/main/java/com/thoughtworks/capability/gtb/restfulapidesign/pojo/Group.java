package com.thoughtworks.capability.gtb.restfulapidesign.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 15:41
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.pojo
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    private Integer id;

    private String name;

    private String note;

}
