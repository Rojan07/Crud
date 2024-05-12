package com.teacher.crud.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacher.crud.entity.TeacherModel;

import java.util.Optional;


@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel, Integer> {
 Optional<TeacherModel> findByName(String name);
 Boolean existsByName (String name);

}

