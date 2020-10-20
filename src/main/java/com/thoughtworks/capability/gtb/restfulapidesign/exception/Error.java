package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 16:22
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.exception
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private Integer code;
    private String message;
}
