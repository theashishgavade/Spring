package com.ty.CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@PostMapping("/path")
	public Student SaveStudent(@RequestBody Student student) {
		Student save = repository.save(student);
		return save;
	}

	@GetMapping("/all")
	public List<Student> getAll() {
		List<Student> students = repository.findAll();
		return students;
	}

	@DeleteMapping("/delete")
	public String deleteStudent(@RequestParam int id) {
		repository.deleteById(id);
		return "deleted";
	}

	@GetMapping("/fetch")
	public Student fetchById(@RequestParam int id) {
//		Student student = repository.getById(id);
		Optional<Student> op = repository.findById(id);
		Student student = null;
		if (op.isPresent()) {
			student = op.get();
		}
		return student;
	}

}
