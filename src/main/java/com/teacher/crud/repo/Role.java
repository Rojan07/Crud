package com.teacher.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Role extends JpaRepository<Role,Integer> {

    Optional<Role> findByRoleName(String roleName);
}
