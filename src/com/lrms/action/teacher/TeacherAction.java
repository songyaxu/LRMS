package com.lrms.action.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.lrms.entity.Teacher;
import com.lrms.entity.User;
import com.lrms.service.TeacherService;

public class TeacherAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 302800222973177652L;
	private int id;
	private Teacher teacher;
	private TeacherService teacherService;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String add(){
		Teacher tc=getTeacherService().findTeacherByNo(getTeacher().getNo());
		if(tc!=null)
		{
			message="教工号已存在！";
			return "addFailure";
		}
		
		teacher.setPwd(teacher.getNo());
		System.out.println(teacher.getNo());
		this.getTeacherService().save(teacher);
		message="添加成功！";
		return "addSuccess";
	}
	public String delete(){
		Teacher tc=getTeacherService().findTeacherById(id);
		if(tc==null)
		{
			message="出现未知问题！";
			return "deleteFailure";
		}
		this.getTeacherService().delete(tc);
		message="删除成功！";
		return "deleteSuccess";
	}
	public String update(){
		Teacher tc=getTeacherService().findTeacherById(id);
		if(tc==null)
		{
			message="出现未知问题！";
			return "updateFailure";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user.getType()==2)
		{
			if(!user.getNo().equals(tc.getNo()))
			{
				message="无法修改他人信息！";
				return "updateFailure";
			}
		}
		if(user.getType()==3||user.getNo().equals(tc.getNo()))
		{
			if(teacher.getPwd()!=null&&!teacher.getPwd().trim().equals(""))
				tc.setPwd(teacher.getPwd().trim());
			if(teacher.getName()!=null&&!teacher.getName().trim().equals(""))
				tc.setName(teacher.getName().trim());
			if(teacher.getPhone()!=null&&!teacher.getPhone().trim().equals(""))
				tc.setPhone(teacher.getPhone().trim());
			this.getTeacherService().update(tc);
			user.setName(tc.getName());
			session.setAttribute("user",user);
			message="更新成功！";
			return "updateSuccess";
		}
		else
		{
			message="无法修改信息！";
			return "updateFailure";
		}
	}
	public String edit(){
		teacher=getTeacherService().findTeacherById(id);
		return "edit";
	}
}
