package com.lrms.action.course;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lrms.entity.Course;
import com.lrms.entity.Page;
import com.lrms.entity.Room;
import com.lrms.entity.Student;
import com.lrms.entity.Teacher;
import com.lrms.entity.User;
import com.lrms.service.CourseService;
import com.lrms.service.RoomService;
import com.lrms.service.StudentService;
import com.lrms.service.TeacherService;
import com.lrms.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport{
	private CourseService courseService;
	private TeacherService teacherService;
	private StudentService studentService;
	private Page roomPage;
	private int currentPage;
	private int res;
	private RoomService roomService;
	private final int everyPage=10;
	private String date;
	private Course course;
	private int id;
	private int courseNo;
	private int stateCode;
	private String message;
	@JSON(serialize=false)
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@JSON(serialize=false)
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCourseNo() {
		return courseNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
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
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Page getRoomPage() {
		return roomPage;
	}
	public void setRoomPage(Page roomPage) {
		this.roomPage = roomPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@JSON(serialize=false)
	public RoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public String book(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("flag", "0");
		return SUCCESS;
	}
	public String update(){
		Course cs=this.getCourseService().findById(id);
		if(cs!=null)
		{
			cs.setStatus(res);
			this.getCourseService().update(cs);
			stateCode=1;
			message="审核成功！";
			return "updateSuccess";
		}
		stateCode=0;
		this.getCourseService().update(cs);		
		message="审核失败，没有相关记录";
		return ERROR;
	}
	public String delete(){
		Course cs=this.getCourseService().findById(id);
		this.getCourseService().delete(cs);
		message="删除成功";
		stateCode=1;
		return "deleteSuccess";
	}
	public String search(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.roomService.roomCounts();
		setRoomPage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Room> rooms=this.roomService.queryByPage(roomPage);
		session.setAttribute("roomPage", roomPage);
		String[] time=date.split("-");
		List<Course> courses=this.getCourseService().findByDateAndCourseNo(Integer.valueOf(time[0]), Integer.valueOf(time[1]), Integer.valueOf(time[2]), courseNo);
		for(int i=0;i<rooms.size();i++)
		{
			rooms.get(i).setState(0);
			for(int j=0;j<courses.size();j++)
			{
				if(courses.get(j).getRoomId()==rooms.get(i).getId())
					rooms.get(i).setState(1);
			}
			
		}
		session.setAttribute("flag", "1");
		session.setAttribute("rooms", rooms);
		session.setAttribute("date", date);
		session.setAttribute("courseNo", courseNo);
		return SUCCESS;
	}
	public String nextPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.roomService.roomCounts();
		roomPage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Room> rooms=this.roomService.queryByPage(roomPage);
		session.setAttribute("roomPage", roomPage);
		String[] time=((String)session.getAttribute("date")).split("-");
		List<Course> courses=this.getCourseService().findByDateAndCourseNo(Integer.valueOf(time[0]), Integer.valueOf(time[1]), Integer.valueOf(time[2]), (int)session.getAttribute("courseNo"));
		for(int i=0;i<rooms.size();i++)
		{
			for(int j=0;j<courses.size();j++)
			{
				if(courses.get(j).getRoomId()==rooms.get(i).getId())
					rooms.get(i).setState(1);
			}
			rooms.get(i).setState(0);
		}
		session.setAttribute("flag", "1");
		session.setAttribute("rooms", rooms);
		return SUCCESS;
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.roomService.roomCounts();
		roomPage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Room> rooms=this.roomService.queryByPage(roomPage);
		session.setAttribute("roomPage", roomPage);
		String[] time=((String)session.getAttribute("date")).split("-");
		List<Course> courses=this.getCourseService().findByDateAndCourseNo(Integer.valueOf(time[0]), Integer.valueOf(time[1]), Integer.valueOf(time[2]), (int)session.getAttribute("courseNo"));
		for(int i=0;i<rooms.size();i++)
		{
			for(int j=0;j<courses.size();j++)
			{
				if(courses.get(j).getRoomId()==rooms.get(i).getId())
					rooms.get(i).setState(1);
			}
			rooms.get(i).setState(0);
		}
		session.setAttribute("flag", "1");
		session.setAttribute("rooms", rooms);
		return SUCCESS;
	}
	public String keep(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if(date!=null&&!date.equals(""))
			session.setAttribute("date", date);
		else
		{
			stateCode=0;
			message="条件缺失！";
			return "false";
		}
		if(courseNo!=0)
			session.setAttribute("courseNo", courseNo);
		else
		{
			stateCode=0;
			message="条件缺失！";
			return "false";
		}
		if(id!=0)
			session.setAttribute("roomid", id);
		else
		{
			stateCode=0;
			message="条件缺失！";
			return "false";
		}
		stateCode=1;
		message="预约成功！";
		return "ok";
	}
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int roomid=(int)session.getAttribute("roomid");
		if(roomid==0)
		{
			stateCode=0;
			message="预约失败";
			return "addFalse";
		}
		String date=(String)session.getAttribute("date");
		if(date==null||date.equals(""))
		{
			stateCode=0;
			message="预约失败";
			return "addFalse";
		}
		int courseNo=(int)session.getAttribute("courseNo");
		if(courseNo==0)
		{
			stateCode=0;
			message="预约失败";
			return "addFalse";
		}
		
		Room room=this.getRoomService().findRoomById(roomid);
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			stateCode=0;
			message="预约失败";
			return "addFalse";
		}
		if(room.getStuNum()<course.getStuNum())
		{
			stateCode=0;
			message="实验室人数过多";
			return "addFalse";
		}
		Student st=this.getStudentService().findStudentById(user.getId());
		Teacher t=this.getTeacherService().findTeacherBuCourseName(st.getCourseName());
		course.setRoomId(roomid);
		course.setRoomName(room.getName());
		course.setStudentId(user.getId());
		course.setStudentName(user.getName());
		course.setStatus(0);
		course.setCourseName(st.getCourseName());
		course.setTeacherId(t.getId());
		course.setTeacherName(t.getName());
		course.setCourseNo(courseNo);
		String[] time=date.split("-");
		course.setYear(Integer.valueOf(time[0]));
		course.setMonth(Integer.valueOf(time[1]));
		course.setDay(Integer.valueOf(time[2]));
		this.getCourseService().save(course);
		stateCode=1;
		message="预约成功";
		return "addSuccess";
	}
	public String check(){
		course=this.getCourseService().findById(id);
		return "check";
	}
}
