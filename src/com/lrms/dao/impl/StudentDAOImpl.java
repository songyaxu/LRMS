package com.lrms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lrms.dao.StudentDAO;
import com.lrms.entity.Page;
import com.lrms.entity.Student;

public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Student findStudentByNo(String no) {
		String hql = "from Student student where student.no='"
				+ no + "'";
		List<Student> students = (List<Student>) this.getHibernateTemplate().find(hql);
		if (students.size() > 0) {
			return students.get(0);
		}
		return null;
	}

	@Override
	public Student findStudentById(int id) {
		return (Student)this.getHibernateTemplate().get(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Student loginStudent(Student student) {
		String hql = "from Student student where student.no='"
				+ student.getNo() + "' and student.pwd='"
				+ student.getPwd() + "'";
		List<Student> students = (List<Student>) this.getHibernateTemplate().find(hql);
		if (students.size() > 0) {
			return students.get(0);
		}
		return null;
	}

	@Override
	public void update(Student student) {
		this.getHibernateTemplate().update(student);
	}

	@Override
	public void delete(Student student) {
		this.getHibernateTemplate().delete(student);
	}

	@Override
	public void save(Student student) {
		this.getHibernateTemplate().save(student);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Student> queryByPage(Page page) {
		return (List<Student>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery("from Student a order by a.id desc");  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}

	@Override
	public int studentCounts() {
		int rowTotal=0;
		rowTotal = ((Long)this.getHibernateTemplate().find("select count(*) from Student").get(0)).intValue();
		return rowTotal;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Student findStudentByCourseName(String courseName) {
		String hql = "from Student student where student.courseName='"
				+ courseName + "'";
		List<Student> students = (List<Student>) this.getHibernateTemplate().find(hql);
		if (students.size() > 0) {
			return students.get(0);
		}
		return null;
	}
}
