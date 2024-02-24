package com.pee.dockerized.postgresql.repository;

import com.pee.dockerized.postgresql.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
