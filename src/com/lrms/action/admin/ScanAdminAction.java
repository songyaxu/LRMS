package com.lrms.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.lrms.entity.Admin;
import com.lrms.entity.Page;
import com.lrms.service.AdminService;
import com.lrms.util.PageUtil;

public class ScanAdminAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8603513762614322358L;
	private Admin admin;
	private Page adminPage;
	private int currentPage;
	private AdminService adminService;
	private final int everyPage=10;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Page getAdminPage() {
		return adminPage;
	}
	public void setAdminPage(Page adminPage) {
		this.adminPage = adminPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.adminService.adminCounts();
		setAdminPage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Admin> admins=this.adminService.queryByPage(adminPage);
		session.setAttribute("admins", admins);
		session.setAttribute("adminPage", adminPage);
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.adminService.adminCounts();
		adminPage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Admin> admins=this.adminService.queryByPage(adminPage);
		session.setAttribute("admins", admins);
		session.setAttribute("adminPage", adminPage);
		return "NextPage";
		
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.adminService.adminCounts();
		adminPage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Admin> admins=this.adminService.queryByPage(adminPage);
		session.setAttribute("admins", admins);
		session.setAttribute("adminPage", adminPage);
		return "frontPage";
	}
}
