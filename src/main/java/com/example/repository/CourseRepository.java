package com.example.repository;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CourseEntity;

@Configurable
@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

	CourseEntity findOne(Integer courseId);

	CourseEntity findByName(String name);

}
