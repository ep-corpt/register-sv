package com.ep.registersv.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class MessageModel {
    @Valid
    @NotNull(message = "User Detail is required")
    private UserDetail userDetail;
    @Valid
    @NotNull(message = "Company Detail is required")
    private CompanyDetail companyDetail;
    @Valid
    @NotNull(message = "Credential Detail is required")
    private CredentialDetail credentialDetail;
}
