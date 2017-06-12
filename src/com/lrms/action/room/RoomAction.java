package com.lrms.action.room;


import org.apache.struts2.json.annotations.JSON;

import com.lrms.entity.Room;
import com.lrms.service.RoomService;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 332354665431906025L;
	private RoomService roomService;
	private int id;
	private String message;
	private Room room;
	@JSON(serialize=false)
	public RoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String add(){
		this.getRoomService().save(room);
		message="添加成功！";
		return "addSuccess";
	}
	public String delete(){
		Room rm=getRoomService().findRoomById(id);
		if(rm==null)
		{
			message="出现未知问题！";
			return "deleteFailure";
		}
		this.getRoomService().delete(rm);
		message="删除成功！";
		return "deleteSuccess";
	}
	public String update(){
		Room rm=this.getRoomService().findRoomById(id);
		if(rm==null)
		{
			message="出现未知问题！";
			return "updateFailure";
		}
		if(room.getName()!=null&&!room.getName().trim().equals(""))
			rm.setName(room.getName().trim());
		if(room.getLocation()!=null&&!room.getLocation().trim().equals(""))
			rm.setLocation(room.getLocation().trim());
		if(room.getRemark()!=null&&!room.getRemark().trim().equals(""))
			rm.setRemark(room.getRemark().trim());
		this.getRoomService().update(rm);
		message="更新成功！";
		return "updateSuccess";
	}
	public String edit(){
		room=getRoomService().findRoomById(id);
		return "edit";
	}
}
