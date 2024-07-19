package com.anonymous63.vehicalservicesystem.repositories;

import com.anonymous63.vehicalservicesystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
