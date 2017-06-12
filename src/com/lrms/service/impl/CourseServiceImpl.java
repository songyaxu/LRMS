package com.lrms.service.impl;

import java.util.List;

import com.lrms.dao.CourseDAO;
import com.lrms.entity.Course;
import com.lrms.entity.Page;
import com.lrms.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private CourseDAO courseDao;
	
	public CourseDAO getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public Course findById(int id) {
		return this.getCourseDao().findById(id);
	}

	@Override
	public void delete(Course course) {
		this.getCourseDao().delete(course);
	}

	@Override
	public void save(Course course) {
		this.getCourseDao().save(course);
	}

	@Override
	public void update(Course course) {
		this.getCourseDao().update(course);
	}

	@Override
	public List<Course> queryByPage(Page page, String[] column, String[] data, int size) {
		return this.getCourseDao().queryByPage(page, column, data, size);
	}

	@Override
	public int courseCounts(String[] column, String[] data, int size) {
		return this.getCourseDao().courseCounts(column, data, size);
	}

	@Override
	public List<Course> findByDateAndCourseNo(int year, int month, int day, int courseNo) {
		return this.getCourseDao().findByDateAndCourseNo(year, month, day, courseNo);
	}
	
}
