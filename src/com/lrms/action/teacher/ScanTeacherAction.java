package com.lrms.action.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.lrms.entity.Page;
import com.lrms.entity.Teacher;
import com.lrms.service.TeacherService;
import com.lrms.util.PageUtil;

public class ScanTeacherAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7236063679821783012L;
	private Teacher teacher;
	private Page teacherPage;
	private int currentPage;
	private TeacherService teacherService;
	private final int everyPage=10;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Page getTeacherPage() {
		return teacherPage;
	}
	public void setTeacherPage(Page teacherPage) {
		this.teacherPage = teacherPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.teacherService.teacherCounts();
		setTeacherPage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Teacher> teachers=this.teacherService.queryByPage(teacherPage);
		session.setAttribute("teachers", teachers);
		session.setAttribute("teacherPage", teacherPage);
		System.out.println("total"+totalCount);
		for(int i=0;i<teachers.size();i++)
		{
			System.out.println(teachers.get(i).getNo());
		}
		
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.teacherService.teacherCounts();
		teacherPage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Teacher> teachers=this.teacherService.queryByPage(teacherPage);
		session.setAttribute("teachers", teachers);
		session.setAttribute("teacherPage", teacherPage);
		return "NextPage";
		
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.teacherService.teacherCounts();
		teacherPage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Teacher> teachers=this.teacherService.queryByPage(teacherPage);
		session.setAttribute("teachers", teachers);
		session.setAttribute("teacherPage", teacherPage);
		return "frontPage";
	}
}
