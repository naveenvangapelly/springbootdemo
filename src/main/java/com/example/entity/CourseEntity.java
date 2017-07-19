package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class CourseEntity implements Serializable {

	private static final long serialVersionUID = -7719425668418277840L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "room")
	private Integer room;

	@Column(name = "professor")
	private String professor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

}
