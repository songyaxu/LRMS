package com.lrms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lrms.dao.CourseDAO;
import com.lrms.entity.Course;
import com.lrms.entity.Page;
import com.lrms.entity.Teacher;

public class CourseDAOImpl extends HibernateDaoSupport implements CourseDAO{

	@Override
	public Course findById(int id) {
		return this.getHibernateTemplate().get(Course.class, id);
	}

	@Override
	public void delete(Course course) {
		this.getHibernateTemplate().delete(course);
	}

	@Override
	public void save(Course course) {
		this.getHibernateTemplate().save(course);
	}

	@Override
	public void update(Course course) {
		this.getHibernateTemplate().update(course);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Course> queryByPage(Page page, String[] column, String[] data,int size) {
		return (List<Course>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException { 
            	String hql="from Course c ";
            	if(size!=0)
            	{
            		hql+="where ";
            		for(int i=0;i<size;i++)
	            	{
            			if(i>0)
	            			hql+=" and ";
	            		hql+=" c."+column[i]+"='"+data[i]+"'";
	            	}
            	}
            	System.out.println(hql);
                Query query = session.createQuery(hql);  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}

	@Override
	public int courseCounts(String[] column, String[] data, int size) {
		String hql="select count(*) from Course c ";
    	if(size!=0)
    	{
    		hql+="where ";
    		for(int i=0;i<size;i++)
        	{
    			if(i>0)
        			hql+=" and ";
        		hql+=" c."+column[i]+"='"+data[i]+"'";
        	}
    	}
    	int rowTotal=0;
		rowTotal = ((Long)this.getHibernateTemplate().find(hql).get(0)).intValue();
		return rowTotal;
	}

	@Override
	public List<Course> findByDateAndCourseNo(int year, int month, int day, int courseNo) {
		String hql="from Course c where c.year="
				+ year+ " and c.month="+month+" and c.day="+day+" and c.courseNo="+courseNo;
		System.out.println(hql);
		List<Course> courses=(List<Course>)this.getHibernateTemplate().find(hql);
		return courses;
	}
	
}
