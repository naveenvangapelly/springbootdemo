package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.StudentEntity;

@Configurable
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
	
	
	public StudentEntity findByLastName(String lastName);
	
	public StudentEntity findByFirstName(String firstName);	 
	
	@Query(value = "select count(*) from student where firstname=?1", nativeQuery= true)
	public int countByFirstName(String firstName);	
	
	@Query(value = "SELECT * FROM student", nativeQuery = true)
	public List<StudentEntity> findStudents();

	

	
	
}
