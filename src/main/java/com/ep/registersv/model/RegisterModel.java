package com.ep.registersv.model;

import lombok.Data;

@Data
public class RegisterModel {
    private UserInfo userInfo;
    private CompanyInfo companyInfo;
    private CredentialInfo credentialInfo;
}
