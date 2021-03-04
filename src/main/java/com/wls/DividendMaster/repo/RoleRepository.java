package com.wls.DividendMaster.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wls.DividendMaster.domain.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}