package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.Getter;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 17:40
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.exception
 * @version: 1.0
 */
@Getter
public class GroupNotExistException extends  RuntimeException {
    private Error error;
    public  GroupNotExistException(Integer code, String message){
        error = new Error(code,message);
    }
}
