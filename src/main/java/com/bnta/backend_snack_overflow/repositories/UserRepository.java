package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
