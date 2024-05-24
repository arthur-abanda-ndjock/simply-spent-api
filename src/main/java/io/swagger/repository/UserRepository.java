package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailId(String emailId);
}