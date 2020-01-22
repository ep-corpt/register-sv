package com.ep.registersv.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CompanyDetail {
    @Size(max = 30, message = "Company name cannot more than 30 characters")
    @NotNull(message = "Company name is required")
    private String companyName;

}
