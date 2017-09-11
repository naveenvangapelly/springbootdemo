package com.example.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.bean.Student;
import com.example.entity.StudentEntity;

public class StudentUtils {

	public File convert(MultipartFile file) throws IOException {

		System.out.println("gggggg " + file);

		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	public StudentEntity convertLineToStudentEntity(String line) {

		String[] str = line.split(",");
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstname(str[0]);
		studentEntity.setLastname(str[1]);
		studentEntity.setAddress(str[2]);
		studentEntity.setPhone(str[3]);

		return studentEntity;

	}
}
