package com.ep.registersv.common;

import lombok.Data;

@Data
public class RegisterException extends Exception {

    private String statusCode = "00001";
    private String statusDesc;

    public RegisterException(String statusCode, String statusDesc) {
        super(statusDesc);
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
    }
}
