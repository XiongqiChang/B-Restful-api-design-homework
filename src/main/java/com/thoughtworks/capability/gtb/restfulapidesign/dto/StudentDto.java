package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 16:05
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.dto
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private String name;

    private String gender;

    private String note;

}
