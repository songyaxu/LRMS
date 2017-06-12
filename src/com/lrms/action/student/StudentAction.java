package com.lrms.action.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.lrms.entity.Student;
import com.lrms.entity.Teacher;
import com.lrms.entity.User;
import com.lrms.service.StudentService;
import com.lrms.service.TeacherService;

public class StudentAction extends ActionSupport{
	private static final long serialVersionUID = 9056665237987325857L;
	private StudentService studentService;
	private TeacherService teacherService;
	private int id;
	private int stateCode;
	private String message;
	private Student student;
	@JSON(serialize=false)
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String edit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Student st=this.getStudentService().findStudentById(id);
		if(st==null)
		{
			User user=(User) session.getAttribute("user");
			Teacher t=this.getTeacherService().findTeacherById(user.getId());
			st=this.getStudentService().findStudentByCourseName(t.getCourseName());
			
		}
		setStudent(st);
		return "editSuccess";
	}
	public String update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		if(user.getType()==2){
			Teacher t=this.getTeacherService().findTeacherById(user.getId());
			Student st=this.getStudentService().findStudentByCourseName(t.getCourseName());
			if(st!=null)
			{
				if(student.getNo()!=null&&!student.getNo().trim().equals(""))
				{
					st.setNo(student.getNo().trim());
					if(student.getPwd()!=null&&!student.getPwd().trim().equals(""))
						st.setPwd(student.getPwd());
				}
				if(student.getName()!=null&&!student.getName().trim().equals(""))
					st.setName(student.getName().trim());
				if(student.getPhone()!=null&&!student.getPhone().trim().equals(""))
					st.setPhone(student.getPhone().trim());
				this.getStudentService().update(st);
				stateCode=1;
				message="修改成功！";
				return "update";
			}
			else
			{
				student.setCourseName(t.getCourseName());
				if(student.getPwd()!=null&&student.getPwd().trim().equals(""))
					student.setPwd(student.getNo());
				this.getStudentService().save(student);
				stateCode=1;
				message="设置成功！";
				return "update";
			}
		}else if(user.getType()==1){
			Student st=this.getStudentService().findStudentById(user.getId());
			if(!user.getNo().equals(st.getNo()))
			{
				stateCode=0;
				message="无法修改！";
				return "updateError";
			}
			else
			{
				if(student.getPwd()!=null&&!student.getPwd().equals(""))
					st.setPwd(student.getPwd());
				if(student.getPhone()!=null&&!student.getPhone().trim().equals(""))
					st.setPhone(student.getPhone().trim());
				this.getStudentService().update(st);
				stateCode=1;
				message="修改成功！";
				return "update";
	
			}	
		}else{
			stateCode=0;
			message="无法修改！";
			return "updateError";	
		}
	}
}
