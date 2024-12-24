package com.ty.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//		Optional<Student> op = repository.findById(id);
//		Student student = null;
//		if (op.isPresent()) {
//			student = op.get();
//		}
//		return student;

//		Student student = op.orElseThrow(() -> new RuntimeException("Data Not Found"));
//		return student;
//		---------------------------------------------------------------
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Data Not Found"));
	}

	// Sort
	@GetMapping("/sort")
	public List<Student> sort(@RequestParam String sort) {
		List<Student> sorted = repository.findAll(Sort.by(sort).descending());
		return sorted;
	}

	// Pagination
	@GetMapping("/page")
	public List<Student> pagination(@RequestParam Integer pagenumber) {
		Pageable pagaeble = PageRequest.of(pagenumber - 1, 3);
		List<Student> list = repository.findAll(pagaeble).toList();
		return list;
	}

	// QueryByExample
	@GetMapping("/example")
	public List<Student> example(@RequestBody Student student) {
		System.out.println(student);
		Example<Student> data = Example.of(student);
		List<Student> all = repository.findAll(data);
		System.out.println(all);
		return all;
	}

	// Custom Query
	@GetMapping("/nameforQuery/{name}")
	public List<Student> getByName(@PathVariable String name) {
		return repository.getByName(name); 
	}

	// Custom Method
	@GetMapping("/nameforMethod/{name}")
	public List<Student> findByName(@PathVariable String name) {
		return repository.findByName(name); 
	}

	// Passing Multiple Custom Query and Method 
	@GetMapping("/pa/phone/{phone}/address/{address}")
	public List<Student> getByPhoneAndAddress(@PathVariable long phone, @PathVariable String address) {
		return repository.findByPhoneAndAddress(phone, address);
	}

}
