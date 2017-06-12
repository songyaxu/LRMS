package com.lrms.service;

import java.util.List;

import com.lrms.entity.Course;
import com.lrms.entity.Page;

public interface CourseService {
	public Course findById(int id);
	public List<Course> findByDateAndCourseNo(int year,int month,int day,int courseNo);
	public void delete(Course course);
	public void save(Course course);
	public void update(Course course);
	public List<Course> queryByPage(final Page page,String[] column,String[] data,int size);
	public int courseCounts(String[] column,String[] data,int size);
}
