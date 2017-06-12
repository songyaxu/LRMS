package com.lrms.service.impl;

import java.util.List;

import com.lrms.dao.TeacherDAO;
import com.lrms.entity.Page;
import com.lrms.entity.Teacher;
import com.lrms.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	@Override
	public List<Teacher> queryByPage(Page page) {
		return this.getTeacherDao().queryByPage(page);
	}

	@Override
	public int teacherCounts() {
		return this.getTeacherDao().teacherCounts();
	}

	private TeacherDAO teacherDao;

	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public Teacher findTeacherByNo(String no) {
		return this.getTeacherDao().findTeacherByNo(no);
	}

	@Override
	public Teacher findTeacherById(int id) {
		return this.getTeacherDao().findTeacherById(id);
	}

	@Override
	public Teacher findTeacherBuCourseName(String courseName) {
		return this.getTeacherDao().findTeacherBuCourseName(courseName);
	}

	@Override
	public Teacher loginTeacher(Teacher teacher) {
		return this.getTeacherDao().loginTeacher(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		this.getTeacherDao().update(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		this.getTeacherDao().delete(teacher);
	}

	@Override
	public void save(Teacher teacher) {
		this.getTeacherDao().save(teacher);
	}
	
}
