package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.Course;
import com.example.entity.CourseEntity;
import com.example.repository.CourseRepository;

@Component
public class CourseDao {

	@Autowired
	private CourseRepository courseRepository;

	public CourseEntity getCourse(Integer courseId) {
		CourseEntity courseEntity = courseRepository.findOne(courseId);
		return courseEntity;
	}

	public CourseEntity getCourseProfessor(String name) {
		CourseEntity courseEntity = courseRepository.findByName(name);
		return courseEntity;
	}

	public CourseEntity saveCourse(CourseEntity courseEntity){
		return courseRepository.save(courseEntity);
	}
}
