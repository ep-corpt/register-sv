package com.ep.registersv.common;

import lombok.Data;

import static com.ep.registersv.constant.MessageConstant.STATUS_ERROR;

@Data
public class RegisterException extends Exception {

    private String statusCode = STATUS_ERROR;
    private String statusDesc;

    public RegisterException(String statusDesc) {
        super(statusDesc);
        this.statusDesc = statusDesc;
    }

    public RegisterException(String statusDesc, Throwable throwable) {
        super(statusDesc, throwable);
        this.statusDesc = statusDesc;
    }
}