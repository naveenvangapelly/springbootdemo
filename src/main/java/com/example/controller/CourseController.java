package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.bean.Course;
import com.example.dao.CourseDao;
import com.example.entity.CourseEntity;

@RestController
public class CourseController {

	@Autowired
	private CourseDao courseDao;

	@RequestMapping(value = "/example/courses/professor/{courseName}", method = RequestMethod.GET)
	public String getCourseProfessor(@PathVariable(value = "courseName") String courseName) {

		CourseEntity courseEntity = courseDao.getCourseProfessor(courseName);

		return courseEntity.getProfessor();

	}

	@RequestMapping(value = "/example/courses/{courseId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Course getCourse(@PathVariable(value = "courseId") Integer courseId) {

		Course course = new Course();
		CourseEntity courseEntity = courseDao.getCourse(courseId);

		course.setId(courseEntity.getId());
		course.setName(courseEntity.getName());
		course.setRoom(courseEntity.getRoom());
		course.setProfessor(courseEntity.getProfessor());
		return course;
	}

	@RequestMapping(value = "/example/courses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public CourseEntity saveCourse(@RequestBody Course course) {

		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setId(course.getId());
		courseEntity.setName(course.getName());
		courseEntity.setRoom(course.getRoom());
		courseEntity.setProfessor(course.getProfessor());

		return courseDao.saveCourse(courseEntity);

	}
}
