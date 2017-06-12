package com.lrms.service.impl;

import com.lrms.service.AdminService;

import java.util.List;

import com.lrms.dao.AdminDAO;
import com.lrms.entity.Admin;
import com.lrms.entity.Page;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDao;
	
	
	public AdminDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin findAdminByNo(String no) {
		return this.getAdminDao().findAdminByNo(no);
	}

	@Override
	public Admin findAdminById(int id) {
		return this.getAdminDao().findAdminById(id);
	}

	@Override
	public void update(Admin admin) {
		this.getAdminDao().update(admin);
	}

	@Override
	public void delete(Admin admin) {
		this.getAdminDao().delete(admin);
	}

	@Override
	public void save(Admin admin) {
		this.getAdminDao().save(admin);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		return this.getAdminDao().loginAdmin(admin);
	}

	@Override
	public List<Admin> queryByPage(Page page) {
		return this.getAdminDao().queryByPage(page);
	}

	@Override
	public int adminCounts() {
		return this.getAdminDao().adminCounts();
	}
	
	
}
