package com.ep.registersv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.ep.registersv.constant.MessageConstant.REGISTER_SUCCESSFULLY;
import static com.ep.registersv.constant.MessageConstant.STATUS_SUCCESS;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private String statusCode = STATUS_SUCCESS;
    private String statusDesc = REGISTER_SUCCESSFULLY;
}
