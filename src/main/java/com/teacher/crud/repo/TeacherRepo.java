package com.teacher.crud.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacher.crud.entity.TeacherModel;

import java.util.Optional;


@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel, Integer> {
 TeacherModel findByName(String name);

}

