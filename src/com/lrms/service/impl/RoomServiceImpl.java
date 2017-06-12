package com.lrms.service.impl;

import java.util.List;

import com.lrms.dao.RoomDAO;
import com.lrms.entity.Page;
import com.lrms.entity.Room;
import com.lrms.service.RoomService;

public class RoomServiceImpl implements RoomService{
	private RoomDAO roomDao;
	
	public RoomDAO getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDAO roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public Room findRoomById(int id) {
		return this.getRoomDao().findRoomById(id);
	}

	@Override
	public List<Room> queryByPage(Page page) {
		return this.getRoomDao().queryByPage(page);
	}

	@Override
	public int roomCounts() {
		return this.getRoomDao().roomCounts();
	}

	@Override
	public void update(Room room) {
		this.getRoomDao().update(room);
	}

	@Override
	public void delete(Room room) {
		this.getRoomDao().delete(room);
	}

	@Override
	public void save(Room room) {
		this.getRoomDao().save(room);
	}
	
}
