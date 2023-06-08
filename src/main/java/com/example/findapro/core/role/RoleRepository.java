package com.example.findapro.core.role;

import com.example.findapro.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findRoleByRoleName(String roleName);
}
