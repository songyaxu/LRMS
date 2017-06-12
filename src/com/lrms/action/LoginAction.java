package com.lrms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lrms.entity.Admin;
import com.lrms.entity.Student;
import com.lrms.entity.Teacher;
import com.lrms.entity.User;
import com.lrms.service.AdminService;
import com.lrms.service.StudentService;
import com.lrms.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String no;
	private String name;
	private String pwd;
	private String message;
	private AdminService adminService;
	private StudentService studentService;
	private TeacherService teacherService;
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.removeAttribute("user");
	    Admin ad = adminService.findAdminByNo(this.getNo());
	    if(ad!=null)
	    {
	    	Admin loginAdmin=new Admin(no,pwd);
	    	Admin admin=adminService.loginAdmin(loginAdmin);
	    	if(admin!=null)
	    	{
	    		message="登录成功！";
	    		User user=new User(admin.getId(),admin.getNo(),admin.getName(),admin.getPwd(),3);
	    		session.setAttribute("user", user);
	    		return SUCCESS;
	    	}
	    	else
	    	{
	    		message="密码不正确！";
	    		return INPUT;
	    	}
	    }
	    else
	    {
	    	Student student=studentService.findStudentByNo(no);
	    	if(student!=null)
	    	{
	    		Student loginSt=new Student(no,getPwd());
	    		Student st=studentService.loginStudent(loginSt);
	    		if(st!=null)
	    		{
	    			message="登录成功！";
		    		User user=new User(st.getId(),st.getNo(),st.getName(),st.getPwd(),1);
		    		session.setAttribute("user", user);
		    		return SUCCESS;
	    		}
	    		else
	    		{
	    			message="密码不正确！";
		    		return INPUT;
	    		}
	    	}
	    	else
	    	{
	    		Teacher teacher=teacherService.findTeacherByNo(no);
	    		if(teacher!=null)
	    		{
	    			Teacher loginTeacher=new Teacher(no,getPwd());
	    			Teacher tc=teacherService.loginTeacher(loginTeacher);
	    			if(tc!=null)
	    			{
	    				message="登录成功！";
			    		User user=new User(tc.getId(),tc.getNo(),tc.getName(),tc.getPwd(),2);
			    		session.setAttribute("user", user);
			    		return SUCCESS;
	    			}
	    			else
	    			{
	    				message="密码不正确！";
			    		return INPUT;
	    			}
	    		}
	    		else
	    		{	
		    		message="没有此账号，请核对后在登录！";
	    	    	return INPUT;
	    		}
	    	}
	    }
	}
	public String logout()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		message="用户已登出！";
		return "logout";
	}
}
