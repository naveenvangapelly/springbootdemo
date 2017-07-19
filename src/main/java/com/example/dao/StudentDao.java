package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.Student;
import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;

@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;

	public StudentEntity getStudent(Integer studentId) {
		StudentEntity studentEntity = studentRepository.findOne(studentId);
		return studentEntity;
	}

	public List<StudentEntity> getStudents() {
		List<StudentEntity> studentEntityList = studentRepository.findStudents();
		System.out.println("size is:" + studentEntityList.size());
		return studentEntityList;

	}

	public StudentEntity getStudentFirstName(String studentLastName) {
		StudentEntity studentEntity = studentRepository.findByLastName(studentLastName);
		return studentEntity;
	}

	public StudentEntity saveStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}

	public StudentEntity getStudentLastName(String studentFirstName) {
		StudentEntity studentEntity = studentRepository.findByFirstName(studentFirstName);
		return studentEntity;
	}

	public void deleteStudent(Integer studentId) {
		studentRepository.delete(studentId);

	}

	public int countByFirstName(String firstName) {
		return studentRepository.countByFirstName(firstName);

	}

}
