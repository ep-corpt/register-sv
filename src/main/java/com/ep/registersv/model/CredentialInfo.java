package com.ep.registersv.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CredentialInfo {
    @Size(max = 20, message = "Username cannot more than 20 characters")
    @NotNull(message = "Username is required")
    private String username;
    @Size(max = 20, message = "password cannot more than 20 characters")
    @NotNull(message = "Password is required")
    private String password;
}
