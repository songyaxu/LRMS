package com.lrms.service.impl;

import java.util.List;

import com.lrms.dao.StudentDAO;
import com.lrms.entity.Page;
import com.lrms.entity.Student;
import com.lrms.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDao;
	
	public StudentDAO getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Student findStudentByNo(String no) {
		return this.getStudentDao().findStudentByNo(no);
	}

	@Override
	public Student findStudentById(int id) {
		return this.getStudentDao().findStudentById(id);
	}

	@Override
	public Student loginStudent(Student student) {
		return this.getStudentDao().loginStudent(student);
	}

	@Override
	public void update(Student student) {
		this.getStudentDao().update(student);
	}

	@Override
	public void delete(Student student) {
		this.getStudentDao().delete(student);
	}

	@Override
	public void save(Student student) {
		this.getStudentDao().save(student);
	}

	@Override
	public List<Student> queryByPage(Page page) {
		return this.getStudentDao().queryByPage(page);
	}

	@Override
	public int studentCounts() {
		return this.getStudentDao().studentCounts();
	}

	@Override
	public Student findStudentByCourseName(String courseName) {
		return this.getStudentDao().findStudentByCourseName(courseName);
	}

	
}
