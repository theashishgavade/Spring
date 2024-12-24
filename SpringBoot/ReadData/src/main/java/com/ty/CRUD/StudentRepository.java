package com.ty.CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Custom Methods

	public List<Student> findByName(String name);

	public List<Student> findByAddress(String address);

	public List<Student> findByPhoneAndAddress(Long phone, String address);

	public Optional<Student> findByNameAndAddressAndPhone(String name, String address, long phone);

	public List<Student> findByNameOrPhone(String name, long phone);

	// Custom Queries

	@Query("SELECT s FROM Student s WHERE s.name=?1") // Index based parameter
	public List<Student> getByName(String name);

	@Query("SELECT s FROM Student s WHERE s.name=?1 AND s.phone=?2") // Index based parameter
	public List<Student> getData(String name, long phone);

	@Query("SELECT s FROM Student s WHERE s.address=:add") // Naming based parameter
	public List<Student> getByAddress(String add);

	@Query("SELECT s FROM Student s WHERE s.name=:sname AND s.phone=:sphone") // Naming based parameter
	public List<Student> fetchByNamePhone(String sname, long sphone);

}
