package com.kuravita.oauthserver.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuravita.oauthserver.config.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}
