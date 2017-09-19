package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bean.Student;
import com.example.dao.StudentDao;
import com.example.exception.ExceptionHandling;
import com.example.service.StudentService;

@RestController
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandling.class);

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/example/students/lastName/{studentLastName}", method = RequestMethod.GET)
	public String getStudentFirstName(@PathVariable(value = "studentLastName") String studentLastName) {

		String entity =studentService.getStudentFirstName(studentLastName);
		return entity;

	}

	@RequestMapping(value = "/example/students/firstName/{studentFirstName}", method = RequestMethod.GET)
	public String getStudentLastName(@PathVariable(value = "studentFirstName") String studentFirstName) {

		String entity =	studentService.getStudentLastName(studentFirstName);
		return entity;

	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<Student> getStudents() {

		List<Student> enlist =studentService.getStudents();

		return enlist;

	}

	@RequestMapping(value = "/example/students/{studentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Student getstudent(@PathVariable(value = "studentId") Integer studentId) {
		
		LOGGER.info(" student ID is {}", studentId);

		Student student = studentService.getStudent(studentId) ;

		return student;
	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {

	Student student1 = 	studentService.saveStudent(student);
	return student1;

	}

	@RequestMapping(value = "/example/students/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable(value = "studentId") Integer studentId) {
		String string =studentService.deleteStudent(studentId);
		return  string;

	}

	@RequestMapping(value = "/example/students/count/{firstName}", method = RequestMethod.GET)
	public int countStudent(@PathVariable(value = "firstName") String firstName) {
		return studentService.countByFirstName(firstName);
	}


	@RequestMapping(value = "/example/students/upload/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public List<Student> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {

		List<Student> list1 =	studentService.uploadFile(file);
		return list1 ;

	}
}
