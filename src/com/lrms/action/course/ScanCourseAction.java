package com.lrms.action.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lrms.entity.Course;
import com.lrms.entity.Page;
import com.lrms.entity.User;
import com.lrms.service.CourseService;
import com.lrms.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ScanCourseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7236063679221783012L;
	private Course course;
	private Page coursePage;
	private int currentPage;
	private CourseService courseService;
	private int type;
	private final int everyPage=10;
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Page getCoursePage() {
		return coursePage;
	}
	public void setCoursePage(Page coursePage) {
		this.coursePage = coursePage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public int getEveryPage() {
		return everyPage;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(type==2)
		{
			String[] column={
					"status"
				};
			String[] data={
					"0"
			};
			int size=1;
			int totalCount=this.courseService.courseCounts(column,data,size);
			setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
			List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
			session.setAttribute("courses", courses);
			session.setAttribute("coursePage", coursePage);
			
			return SUCCESS;
		}
		if(user.getType()==1)
		{
			if(type==0)
			{
				String[] column={
						"studentId"
					};
				String[] data={
						user.getId()+""
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return SUCCESS;
			}
			if(type==1)
			{
				String[] column={
						"studentId","status"
					};
				String[] data={
						user.getId()+"","1"
				};
				int size=2;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return SUCCESS;
			}
		}else if(user.getType()==2)
		{
			if(type==0)
			{
				String[] column={
						"teacherId"
					};
				String[] data={
						user.getId()+""
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return SUCCESS;
			}
			if(type==1)
			{
				String[] column={
						"teacherId","status"
					};
				String[] data={
						user.getId()+"","1"
				};
				int size=2;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return SUCCESS;
			}
		}
		else
		{
			if(type==0)
			{
				String[] column={
						""
					};
				String[] data={
						""
				};
				int size=0;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return SUCCESS;
			}
			if(type==1)
			{
				String[] column={
						"status"
					};
				String[] data={
						"1"
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, 0));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return SUCCESS;
			}
		}
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(type==2)
		{
			String[] column={
					"status"
				};
			String[] data={
					"0"
			};
			int size=1;
			int totalCount=this.courseService.courseCounts(column,data,size);
			setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
			List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
			session.setAttribute("courses", courses);
			session.setAttribute("coursePage", coursePage);
			
			return "NextPage";
		}
		if(user.getType()==1)
		{
			if(type==0)
			{
				String[] column={
						"studentId"
					};
				String[] data={
						user.getId()+""
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "NextPage";
			}
			if(type==1)
			{
				String[] column={
						"studentId","status"
					};
				String[] data={
						user.getId()+"","1"
				};
				int size=2;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "NextPage";
			}
		}else if(user.getType()==2)
		{
			if(type==0)
			{
				String[] column={
						"teacherId"
					};
				String[] data={
						user.getId()+""
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "NextPage";
			}
			if(type==1)
			{
				String[] column={
						"teacherId","status"
					};
				String[] data={
						user.getId()+"","1"
				};
				int size=2;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "NextPage";
			}
		}
		else
		{
			if(type==0)
			{
				String[] column={
						""
					};
				String[] data={
						""
				};
				int size=0;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "NextPage";
			}
			if(type==1)
			{
				String[] column={
						"status"
					};
				String[] data={
						"1"
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage+1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "NextPage";
			}
		}
		return "NextPage";
		
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(type==2)
		{
			String[] column={
					"status"
				};
			String[] data={
					"0"
			};
			int size=1;
			int totalCount=this.courseService.courseCounts(column,data,size);
			setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
			List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
			session.setAttribute("courses", courses);
			session.setAttribute("coursePage", coursePage);
			
			return "frontPage";
		}
		if(user.getType()==1)
		{
			if(type==0)
			{
				String[] column={
						"studentId"
					};
				String[] data={
						user.getId()+""
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "frontPage";
			}
			if(type==1)
			{
				String[] column={
						"studentId","status"
					};
				String[] data={
						user.getId()+"","1"
				};
				int size=2;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "frontPage";
			}
		}else if(user.getType()==2)
		{
			if(type==0)
			{
				String[] column={
						"teacherId"
					};
				String[] data={
						user.getId()+""
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "frontPage";
			}
			if(type==1)
			{
				String[] column={
						"teacherId","status"
					};
				String[] data={
						user.getId()+"","1"
				};
				int size=2;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "frontPage";
			}
		}
		else
		{
			if(type==0)
			{
				String[] column={
						""
					};
				String[] data={
						""
				};
				int size=0;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "frontPage";
			}
			if(type==1)
			{
				String[] column={
						"status"
					};
				String[] data={
						"1"
				};
				int size=1;
				int totalCount=this.courseService.courseCounts(column,data,size);
				setCoursePage(PageUtil.createPage(everyPage, totalCount, currentPage-1));
				List<Course> courses=this.courseService.queryByPage(coursePage,column,data,size);
				session.setAttribute("courses", courses);
				session.setAttribute("coursePage", coursePage);
				
				return "frontPage";
			}
		}
		return "frontPage";
	}
}
