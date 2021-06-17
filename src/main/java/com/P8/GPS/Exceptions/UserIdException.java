package com.P8.GPS.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.jws.soap.SOAPBinding;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdException extends Exception{

    public UserIdException(String s){

        super(s);
    }
}
