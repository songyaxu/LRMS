package com.lrms.dao;

import java.util.List;

import com.lrms.entity.Page;
import com.lrms.entity.Teacher;

public interface TeacherDAO {
	public Teacher findTeacherByNo(String no);
	public Teacher findTeacherById(int id);
	public Teacher loginTeacher(Teacher teacher);
	public Teacher findTeacherBuCourseName(String courseName);
	public List<Teacher> queryByPage(final Page page);
	public int teacherCounts();
	public void update(Teacher teacher);
	public void delete(Teacher teacher);
	public void save(Teacher teacher);
}
