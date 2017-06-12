package com.lrms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lrms.dao.TeacherDAO;
import com.lrms.entity.Page;
import com.lrms.entity.Teacher;

public class TeacherDAOImpl extends HibernateDaoSupport implements TeacherDAO{

	@SuppressWarnings("unchecked")
	@Override
	public Teacher findTeacherByNo(String no) {
		String hql="from Teacher teacher where teacher.no='"
				+ no + "'";
		List<Teacher> teachers=(List<Teacher>)this.getHibernateTemplate().find(hql);
		if (teachers.size() > 0) {
			return teachers.get(0);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Teacher findTeacherBuCourseName(String courseName) {
		String hql="from Teacher teacher where teacher.courseName='"
				+ courseName + "'";
		List<Teacher> teachers=(List<Teacher>)this.getHibernateTemplate().find(hql);
		if (teachers.size() > 0) {
			return teachers.get(0);
		}
		return null;
	}


	@Override
	public Teacher findTeacherById(int id) {
		return (Teacher)this.getHibernateTemplate().get(Teacher.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Teacher loginTeacher(Teacher teacher) {
		String hql = "from Teacher teacher where teacher.no='"
				+ teacher.getNo() + "' and teacher.pwd='"
				+ teacher.getPwd() + "'";
		List<Teacher> teachers = (List<Teacher>) this.getHibernateTemplate().find(hql);
		if (teachers.size() > 0) {
			return teachers.get(0);
		}
		return null;
	}

	@Override
	public void update(Teacher teacher) {
		this.getHibernateTemplate().update(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		this.getHibernateTemplate().delete(teacher);
	}

	@Override
	public void save(Teacher teacher) {
		this.getHibernateTemplate().save(teacher);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Teacher> queryByPage(Page page) {
		return (List<Teacher>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery("from Teacher a order by a.id desc");  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}

	@Override
	public int teacherCounts() {
		int rowTotal=0;
		rowTotal = ((Long)this.getHibernateTemplate().find("select count(*) from Teacher").get(0)).intValue();
		return rowTotal;
	}

	
}	
