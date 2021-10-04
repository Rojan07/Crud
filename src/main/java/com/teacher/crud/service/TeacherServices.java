package com.teacher.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.teacher.crud.entity.TeacherModel;
import com.teacher.crud.repo.TeacherRepo;



@Service
public class TeacherServices{
	
	@Autowired
	TeacherRepo TeacherRepo;
	
	public TeacherModel saveTeacherModel(TeacherModel TeacherModel) {
		TeacherModel T=TeacherRepo.save(TeacherModel);
		return T;	
	}
	
	public List<TeacherModel> getAllTeacherModel() {
		List<TeacherModel> TeacherModelList = TeacherRepo.findAll();
		return TeacherModelList;
	}
	
	public TeacherModel getTeacherModelById(int id) {
		TeacherModel t= TeacherRepo.findById(id).get();
		return t;
	}
	
	public void deleteTeacherModelById(int id) {
		TeacherRepo.deleteById(id);
	}
	
	public void deleteAll() {
		TeacherRepo.deleteAll();
	}
	
}