   package com.teacher.crud.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacher.crud.entity.TeacherModel;






@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel, Integer> {
	

}

