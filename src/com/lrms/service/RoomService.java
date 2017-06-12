package com.lrms.service;

import java.util.List;

import com.lrms.entity.Page;
import com.lrms.entity.Room;

public interface RoomService {
	public Room findRoomById(int id);
	public List<Room> queryByPage(final Page page);
	public int roomCounts();
	public void update(Room room);
	public void delete(Room room);
	public void save(Room room);
}
