package com.teacher.crud.repo;

import com.teacher.crud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    Optional<RoleRepo> findByRoleName(String roleName);
}
