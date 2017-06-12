package com.lrms.dao;

import java.util.List;

import com.lrms.entity.Admin;
import com.lrms.entity.Page;

public interface AdminDAO {
	public Admin findAdminById(int id);
	public Admin findAdminByNo(String no);
	public Admin loginAdmin(Admin admin);
	public void update(Admin admin);
	public void delete(Admin admin);
	public void save(Admin admin);
	public List<Admin> queryByPage(final Page page);
	public int adminCounts();
}
