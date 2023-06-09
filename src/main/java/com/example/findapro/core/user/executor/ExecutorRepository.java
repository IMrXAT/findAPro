package com.example.findapro.core.user.executor;

import com.example.findapro.domain.users.ExecutorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutorRepository extends JpaRepository<ExecutorProfile, Long> {
    ExecutorProfile findByUsername(String username);
}
