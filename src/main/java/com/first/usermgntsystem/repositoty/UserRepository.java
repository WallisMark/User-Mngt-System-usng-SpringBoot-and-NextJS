package com.first.usermgntsystem.repositoty;

import com.first.usermgntsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
