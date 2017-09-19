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
import com.example.exception.ExceptionHandling;
import com.example.service.StudentService;

@RestController
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandling.class);
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/example/students/lastName/{studentLastName}", method = RequestMethod.GET)
	public String getStudentByFirstName(@PathVariable(value = "studentLastName") String studentLastName) {

		return studentService.getStudentFirstName(studentLastName);

	}

	@RequestMapping(value = "/example/students/firstName/{studentFirstName}", method = RequestMethod.GET)
	public String getStudentByLastName(@PathVariable(value = "studentFirstName") String studentFirstName) {

		return  studentService.getStudentLastName(studentFirstName);
		

	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public List<Student> getStudents() {

		return studentService.getStudents();

		 

	}

	@RequestMapping(value = "/example/students/{studentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Student getstudentById(@PathVariable(value = "studentId") Integer studentId) {

		LOGGER.info(" student ID is {}", studentId);

		return studentService.getStudent(studentId);

	}

	@RequestMapping(value = "/example/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {

		return studentService.saveStudent(student);

	}

	@RequestMapping(value = "/example/students/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable(value = "studentId") Integer studentId) {
		
		return studentService.deleteStudent(studentId);

	}

	@RequestMapping(value = "/example/students/count/{firstName}", method = RequestMethod.GET)
	public int countStudent(@PathVariable(value = "firstName") String firstName) {
		return studentService.countByFirstName(firstName);
	}

	@RequestMapping(value = "/example/students/upload/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public List<Student> uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {

		return  studentService.uploadFile(file);
		

	}
}
