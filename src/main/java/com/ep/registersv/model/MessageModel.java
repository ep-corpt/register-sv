package com.ep.registersv.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class MessageModel {
    @Valid
    @NotNull(message = "User Information is required")
    private UserInfo userInfo;
    @Valid
    @NotNull(message = "Company Information is required")
    private CompanyInfo companyInfo;
    @Valid
    @NotNull(message = "Credential Information is required")
    private CredentialInfo credentialInfo;
}
