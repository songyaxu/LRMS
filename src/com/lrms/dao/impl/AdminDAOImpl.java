package com.lrms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lrms.dao.AdminDAO;
import com.lrms.entity.Admin;
import com.lrms.entity.Page;

public class AdminDAOImpl extends HibernateDaoSupport implements AdminDAO{

	
	@SuppressWarnings("unchecked")
	@Override
	public Admin findAdminByNo(String no) {
		String hql = "from Admin admin where admin.no='"
				+ no + "'";
		List<Admin> admins = (List<Admin>) this.getHibernateTemplate().find(hql);
		if (admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Admin loginAdmin(Admin admin) {
		String hql = "from Admin admin where admin.no='"
				+ admin.getNo() + "' and admin.pwd='"
				+ admin.getPwd() + "'";
		List<Admin> admins = (List<Admin>) this.getHibernateTemplate().find(hql);
		if (admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}
	
	@Override
	public Admin findAdminById(int id) {
		return (Admin)this.getHibernateTemplate().get(Admin.class,id);
	}

	@Override
	public void update(Admin admin) {
		this.getHibernateTemplate().update(admin);
	}

	@Override
	public void delete(Admin admin) {
		this.getHibernateTemplate().delete(admin);
	}

	@Override
	public void save(Admin admin) {
		this.getHibernateTemplate().save(admin);
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Admin> queryByPage(Page page) {
		return (List<Admin>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery("from Admin a order by a.id desc");  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}

	@Override
	public int adminCounts() {
		int rowTotal=0;
		rowTotal = ((Long)this.getHibernateTemplate().find("select count(*) from Admin").get(0)).intValue();
		return rowTotal;
	}
	
}
