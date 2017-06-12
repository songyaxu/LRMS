package com.lrms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lrms.dao.RoomDAO;
import com.lrms.entity.Page;
import com.lrms.entity.Room;

public class RoomDAOImpl extends HibernateDaoSupport implements RoomDAO{

	@Override
	public Room findRoomById(int id) {
		return this.getHibernateTemplate().get(Room.class, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Room> queryByPage(Page page) {
		return (List<Room>)this.getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Query query = session.createQuery("from Room r order by r.id desc");  
                query.setFirstResult(page.getBeginIndex());  
                query.setMaxResults(page.getEveryPage());  
                return query.list();  
            }
        }); 
	}

	@Override
	public int roomCounts() {
		int rowTotal=0;
		rowTotal = ((Long)this.getHibernateTemplate().find("select count(*) from Room").get(0)).intValue();
		return rowTotal;
	}

	@Override
	public void update(Room room) {
		this.getHibernateTemplate().update(room);
	}

	@Override
	public void delete(Room room) {
		this.getHibernateTemplate().delete(room);
	}

	@Override
	public void save(Room room) {
		this.getHibernateTemplate().save(room);
	}
	
}
