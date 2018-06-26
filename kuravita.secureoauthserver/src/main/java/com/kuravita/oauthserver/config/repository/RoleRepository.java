package com.kuravita.oauthserver.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuravita.oauthserver.config.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
