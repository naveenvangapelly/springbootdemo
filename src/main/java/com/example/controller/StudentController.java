package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Student;
import com.example.dao.StudentDao;
import com.example.entity.StudentEntity;

@RestController
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/example/students/lastName/{studentLastName}", method = RequestMethod.GET)
	public String getStudentFirstName(@PathVariable(value = "studentLastName") String studentLastName) {

		StudentEntity studentEntity = studentDao.getStudentFirstName(studentLastName);
		return studentEntity.getFirstname();

	}

	@RequestMapping(value = "/example/students/firstName/{studentFirstName}", method = RequestMethod.GET)
	public String getStudentLastName(@PathVariable(value = "studentFirstName") String studentFirstName) {

		StudentEntity studentEntity = studentDao.getStudentLastName(studentFirstName);
		return studentEntity.getLastname();

	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<>();

		List<StudentEntity> studentEntityList = studentDao.getStudents();
		System.out.println("list size in controller" + studentEntityList.size());
		for (StudentEntity studentEntity : studentEntityList) {
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

	@RequestMapping(value = "/example/students/{studentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Student getstudent(@PathVariable(value = "studentId") Integer studentId) {

		Student student = new Student();

		StudentEntity studentEntity = studentDao.getStudent(studentId);
		student.setId(studentEntity.getId());
		student.setFirstname(studentEntity.getFirstname());
		student.setLastname(studentEntity.getLastname());
		student.setAddress(studentEntity.getAddress());
		student.setPhone(studentEntity.getPhone());
		return student;
	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {

		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstname(student.getFirstname());
		studentEntity.setLastname(student.getLastname());
		studentEntity.setAddress(student.getAddress());
		studentEntity.setPhone(student.getPhone());

		StudentEntity studentEntity1 = studentDao.saveStudent(studentEntity);
		Student student1 = new Student();
		student1.setAddress(studentEntity1.getAddress());
		student1.setFirstname(studentEntity1.getFirstname());
		student1.setLastname(studentEntity1.getLastname());
		student1.setPhone(studentEntity1.getPhone());
		student1.setId(studentEntity1.getId());
		return student1;

	}

	@RequestMapping(value = "/example/students/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable(value = "studentId") Integer studentId) {
		if (studentDao.getStudent(studentId) == null) {
			throw new RuntimeException("reocrd doesnot exist");
		}

		studentDao.deleteStudent(studentId);
		StudentEntity studentEntity = studentDao.getStudent(studentId);
		String s = null;

		if (studentEntity == null) {
			s = "successfullydeleted";
			System.out.println("student is deleted");
		}

		return s;

	}

	@RequestMapping(value = "/example/students/count/{firstName}", method = RequestMethod.GET)
	public int countStudent(@PathVariable(value = "firstName") String firstName) {
		return studentDao.countByFirstName(firstName);

	}

}
