package com.perscholas.casestudy.repositories;

import com.perscholas.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
