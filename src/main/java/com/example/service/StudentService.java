package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.bean.Student;
import com.example.dao.StudentDao;
import com.example.entity.StudentEntity;
import com.example.exception.domain.AccountIdNotFoundException;
import com.example.utils.StudentUtils;

@Service
public class StudentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentDao studentDao;

	public Student getStudent(Integer studentId) {
		Student student = new Student();
		StudentEntity entity = studentDao.getStudent(studentId);
		if(entity  == null){
			
		throw new AccountIdNotFoundException("student not found " + studentId);
		}
		student.setId(entity.getId());
		student.setFirstname(entity.getFirstname());
		student.setLastname(entity.getLastname());
		student.setAddress(entity.getAddress());
		student.setPhone(entity.getPhone());
		return student;

	}

	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<>();
		List<StudentEntity> entityList = studentDao.getStudents();
		if(entityList == null){
			throw new RuntimeException();
		}
		for (StudentEntity studentEntity : entityList) {
			Student student = new Student();
			student.setId(studentEntity.getId());
			student.setFirstname(studentEntity.getFirstname());
			student.setLastname(studentEntity.getLastname());
			student.setAddress(studentEntity.getAddress());
			student.setPhone(studentEntity.getPhone());
			studentList.add(student);
		}

		return studentList;

	}

	public String getStudentFirstName(String studentLastName) {
		
		StudentEntity entity = studentDao.getStudentFirstName(studentLastName);
		if(entity == null){
			throw new RuntimeException();
		}
		
		return entity.getFirstname();

	}

	public String getStudentLastName(String studentFirstName) {

		StudentEntity entity = studentDao.getStudentLastName(studentFirstName);
		if(entity == null){
			throw new RuntimeException();
		}

		return entity.getLastname();
	}

	public Student saveStudent(Student student)  {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstname(student.getFirstname());
		studentEntity.setLastname(student.getLastname());
		studentEntity.setAddress(student.getAddress());
		studentEntity.setPhone(student.getPhone());
		
		StudentEntity studentEntity1 = studentDao.saveStudent(studentEntity);
		if(studentEntity1== null){
			throw new RuntimeException();
		}
		Student student1 = new Student();

		student1.setAddress(studentEntity1.getAddress());
		student1.setFirstname(studentEntity1.getFirstname());
		student1.setLastname(studentEntity1.getLastname());
		student1.setPhone(studentEntity1.getPhone());
		student1.setId(studentEntity1.getId());
		return student1;

	}

	public String deleteStudent(Integer studentId) {
		if (studentDao.getStudent(studentId) == null) {
			throw new RuntimeException("reocrd doesnot exist");
		}

		studentDao.deleteStudent(studentId);
		StudentEntity studentEntity1 = studentDao.getStudent(studentId);
		String s = null;

		if (studentEntity1 == null) {
			s = "successfullydeleted";
			System.out.println("student is deleted");
		}

		return s;

	}

	public int countByFirstName(String firstName) {
	
		return studentDao.countByFirstName(firstName);

	}

	public List<Student> uploadFile(MultipartFile file) throws IOException {
		List<Student> list = new ArrayList<>();
		StudentUtils studentUtils = new StudentUtils();
		File file1 = studentUtils.convert(file);

		BufferedReader bufferedreader = new BufferedReader(new FileReader(file1));

		String Line;
		while ((Line = bufferedreader.readLine()) != null) {
			System.out.println(Line);
			StudentEntity st = studentUtils.convertLineToStudentEntity(Line);
			StudentEntity studentEntity = studentDao.saveStudent(st);
			

			Student student = new Student();
			student.setFirstname(studentEntity.getFirstname());
			student.setLastname(studentEntity.getLastname());
			student.setAddress(studentEntity.getAddress());
			student.setPhone(studentEntity.getPhone());

			list.add(student);
		}
		bufferedreader.close();

		return list;

	}
}
