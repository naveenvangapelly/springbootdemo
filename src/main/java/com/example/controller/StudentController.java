package com.example.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bean.Student;
import com.example.dao.StudentDao;
import com.example.entity.StudentEntity;
import com.example.service.StudentService;
import com.example.utils.StudentUtils;

@RestController
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/example/students/lastName/{studentLastName}", method = RequestMethod.GET)
	public String getStudentFirstName(@PathVariable(value = "studentLastName") String studentLastName) {

	//	StudentEntity studentEntity = studentDao.getStudentFirstName(studentLastName);
		String entity =studentService.getStudentFirstName(studentLastName);
		return entity;

	}

	@RequestMapping(value = "/example/students/firstName/{studentFirstName}", method = RequestMethod.GET)
	public String getStudentLastName(@PathVariable(value = "studentFirstName") String studentFirstName) {

	//	StudentEntity studentEntity = studentDao.getStudentLastName(studentFirstName);
		String entity =	studentService.getStudentLastName(studentFirstName);
		return entity;

	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<Student> getStudents() {
	//List<Student> studentList = new ArrayList<>();

	//	List<StudentEntity> studentEntityList = studentDao.getStudents();
		List<Student> enlist =studentService.getStudents();
	//	System.out.println("list size in controller" + entityList.size());
//	for (StudentEntity studentEntity : entityList) {
//		Student student = new Student();
//		student.setId(studentEntity.getId());
//		student.setFirstname(studentEntity.getFirstname());
//			student.setLastname(studentEntity.getLastname());
//			student.setAddress(studentEntity.getAddress());
//			student.setPhone(studentEntity.getPhone());
//			studentList.add(student);
//	}
		return enlist;

	}

	@RequestMapping(value = "/example/students/{studentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Student getstudent(@PathVariable(value = "studentId") Integer studentId) {

		//Student student = new Student();
	//StudentEntity studentEntity = studentDao.getStudent(studentId);

		Student student = studentService.getStudent(studentId) ;

//		student.setId(entity.getId());
//		student.setFirstname(entity.getFirstname());
//		student.setLastname(entity.getLastname());
//		student.setAddress(entity.getAddress());
//		student.setPhone(entity.getPhone());
		return student;
	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {

//		StudentEntity studentEntity = new StudentEntity();
//		studentEntity.setFirstname(student.getFirstname());
//		studentEntity.setLastname(student.getLastname());
//		studentEntity.setAddress(student.getAddress());
//		studentEntity.setPhone(student.getPhone());

	//	StudentEntity studentEntity1 = studentDao.saveStudent(studentEntity);
		Student student1 = 	studentService.saveStudent(student);
//		Student student1 = new Student();
//
//		student1.setAddress(studentEntity1.getAddress());
//		student1.setFirstname(studentEntity1.getFirstname());
//		student1.setLastname(studentEntity1.getLastname());		
//		student1.setPhone(studentEntity1.getPhone());		
//		student1.setId(studentEntity1.getId());
		return student1;

	}

	@RequestMapping(value = "/example/students/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable(value = "studentId") Integer studentId) {
//	if (studentService.getStudent(studentId) == null) {
//			throw new RuntimeException("reocrd doesnot exist");
//		}
//
//		studentDao.deleteStudent(studentId);
//	StudentEntity studentEntity = studentDao.getStudent(studentId);
		String string =studentService.deleteStudent(studentId);
//		Student student = studentService.getStudent(studentId);
//		String s = null;
//
//		if (student == null) {
//			s = "successfullydeleted";
//			System.out.println("student is deleted");
//		}
//
		return  string;

	}

	@RequestMapping(value = "/example/students/count/{firstName}", method = RequestMethod.GET)
	public int countStudent(@PathVariable(value = "firstName") String firstName) {
		return studentService.countByFirstName(firstName);
	}


	@RequestMapping(value = "/example/students/upload/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public List<Student> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {

	//		List<Student> list = new ArrayList<>();
	//		StudentUtils studentUtils = new StudentUtils();
	//		File file1 = studentUtils.convert(file);
	//
	//		BufferedReader bufferedreader = new BufferedReader(new FileReader(file1));
	//
	//		String Line;
	//		while ((Line = bufferedreader.readLine()) != null) {
	//			System.out.println(Line);
	//			StudentEntity st = studentUtils.convertLineToStudentEntity(Line);
	//			StudentEntity studentEntity = studentDao.saveStudent(st);
	//
	//			Student student = new Student();
	//			student.setFirstname(studentEntity.getFirstname());
	//			student.setLastname(studentEntity.getLastname());
	//			student.setAddress(studentEntity.getAddress());
	//			student.setPhone(studentEntity.getPhone());
	//
	//			list.add(student);
	//		}
	//		bufferedreader.close();
		List<Student> list1 =	studentService.uploadFile(file);
		return list1 ;

	}
}
