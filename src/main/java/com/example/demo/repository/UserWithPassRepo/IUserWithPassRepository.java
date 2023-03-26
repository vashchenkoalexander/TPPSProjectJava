package com.example.demo.repository.UserWithPassRepo;

import com.example.demo.entity.UserWithPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserWithPassRepository extends JpaRepository<UserWithPass, Long> {
    Optional<UserWithPass> findByLogin(String username);
}
