package com.example.findapro.core.role;

import com.example.findapro.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    
    public List<Role> getRoles(){
        return repository.findAll();
    }

}
