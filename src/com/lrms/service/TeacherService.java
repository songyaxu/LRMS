package com.lrms.service;

import java.util.List;

import com.lrms.entity.Page;
import com.lrms.entity.Teacher;

public interface TeacherService {
	public Teacher findTeacherByNo(String no);
	public Teacher findTeacherById(int id);
	public Teacher loginTeacher(Teacher teacher);
	public List<Teacher> queryByPage(final Page page);
	public Teacher findTeacherBuCourseName(String courseName);
	public int teacherCounts();
	public void update(Teacher teacher);
	public void delete(Teacher teacher);
	public void save(Teacher teacher);
}
