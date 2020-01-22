package com.ep.registersv.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "credential_info")
public class CredentialInfo {
    @Id
    private String username;
    private String password;
    private String email;
}
