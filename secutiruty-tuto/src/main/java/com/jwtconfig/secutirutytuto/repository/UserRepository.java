package com.jwtconfig.secutirutytuto.repository;

import com.jwtconfig.secutirutytuto.entity.Role;
import com.jwtconfig.secutirutytuto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
