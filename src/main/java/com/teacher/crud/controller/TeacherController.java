package com.teacher.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.crud.entity.TeacherModel;
import com.teacher.crud.service.TeacherServices;

@RestController
@RequestMapping("/api")
public class TeacherController {

	@Autowired
	TeacherServices TeacherService;

	@PostMapping("/save")
	public TeacherModel saveTeacherModel(@RequestBody TeacherModel t) {
		TeacherModel tea =TeacherService.saveTeacherModel(t);
		return tea;
	}

	@GetMapping("/get")
	public List<TeacherModel> getAllTeacherModel() {
		List<TeacherModel> TeacherModellist=TeacherService.getAllTeacherModel();
		return TeacherModellist;
	}

	@GetMapping("/getbyid/{id}")
	public TeacherModel getTeacherModelById(@PathVariable int id) {
		TeacherModel TeacherModelId = TeacherService.getTeacherModelById(id);
		return TeacherModelId;
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteTeacherModelById(@PathVariable int id) {
		 TeacherService.deleteTeacherModelById(id);

	}


}
