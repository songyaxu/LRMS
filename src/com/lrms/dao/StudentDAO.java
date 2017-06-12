package com.lrms.dao;

import java.util.List;

import com.lrms.entity.Page;
import com.lrms.entity.Student;

public interface StudentDAO {
	public Student findStudentByNo(String no);
	public Student findStudentById(int id);
	public Student findStudentByCourseName(String courseName);
	public Student loginStudent(Student student);
	public void update(Student student);
	public void delete(Student student);
	public void save(Student student);
	public List<Student> queryByPage(final Page page);
	public int studentCounts();
}
