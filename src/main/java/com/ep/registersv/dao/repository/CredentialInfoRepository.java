package com.ep.registersv.dao.repository;


import com.ep.registersv.dao.entity.CredentialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialInfoRepository extends JpaRepository<CredentialInfo, String> {
    Optional<CredentialInfo> findByEmail(String email);
}
