package com.ep.registersv.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDetail {
    @Size(max = 30, message = "Firstname cannot more than 30 characters")
    @NotBlank(message = "Firstname is required")
    private String firstName;

    @Size(max = 30, message = "Lastname cannot more than 30 characters")
    @NotBlank(message = "Lastname is required")
    private String lastName;

    @Size(max = 30, message = "Email cannot more than 25 characters")
    @NotBlank(message = "Email is required")
    private String email;
}
