package com.thoughtworks.capability.gtb.restfulapidesign.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 15:40
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.pojo
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer id;

    private String name;

    private String gender;

    private String note;
}
