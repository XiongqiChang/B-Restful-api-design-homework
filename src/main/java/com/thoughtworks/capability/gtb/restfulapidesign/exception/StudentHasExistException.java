package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 17:06
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.exception
 * @version: 1.0
 */
@Getter
public class StudentHasExistException extends  RuntimeException {
    private Error error;
    public  StudentHasExistException(Integer code, String message){
        error = new Error(code,message);
    }
}
