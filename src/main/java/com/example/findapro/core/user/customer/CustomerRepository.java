package com.example.findapro.core.user.customer;

import com.example.findapro.domain.users.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerProfile, Long> {
    public CustomerProfile findByUsername(String username);
}
