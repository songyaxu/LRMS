package com.lrms.action.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.lrms.entity.Student;
import com.lrms.entity.Page;
import com.lrms.service.StudentService;
import com.lrms.util.PageUtil;

public class ScanStudentAction extends ActionSupport{
	private static final long serialVersionUID = -8603513762614322358L;
	private Student student;
	private Page studentPage;
	private int currentPage;
	private StudentService studentService;
	private final int everyPage=10;
	

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Page getStudentPage() {
		return studentPage;
	}
	public void setStudentPage(Page studentPage) {
		this.studentPage = studentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.studentService.studentCounts();
		setStudentPage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Student> students=this.studentService.queryByPage(studentPage);
		session.setAttribute("students", students);
		session.setAttribute("studentPage", studentPage);
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.studentService.studentCounts();
		studentPage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Student> students=this.studentService.queryByPage(studentPage);
		session.setAttribute("students", students);
		session.setAttribute("studentPage", studentPage);
		return "NextPage";
		
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.studentService.studentCounts();
		studentPage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Student> students=this.studentService.queryByPage(studentPage);
		session.setAttribute("students", students);
		session.setAttribute("studentPage", studentPage);
		return "frontPage";
	}
}
