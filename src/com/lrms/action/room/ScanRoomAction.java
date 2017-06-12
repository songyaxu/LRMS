package com.lrms.action.room;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lrms.entity.Page;
import com.lrms.entity.Room;
import com.lrms.service.RoomService;
import com.lrms.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ScanRoomAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7236063679821783012L;
	private Room room;
	private Page roomPage;
	private int currentPage;
	private RoomService roomService;
	private final int everyPage=10;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Page getRoomPage() {
		return roomPage;
	}
	public void setRoomPage(Page roomPage) {
		this.roomPage = roomPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public RoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.roomService.roomCounts();
		setRoomPage(PageUtil.createPage(everyPage, totalCount, 0));
		List<Room> rooms=this.roomService.queryByPage(roomPage);
		session.setAttribute("rooms", rooms);
		session.setAttribute("roomPage", roomPage);
		
		return SUCCESS;
	}
	public String nextPage(){
		//ÏÂÒ»Ò³
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.roomService.roomCounts();
		roomPage=PageUtil.createPage(everyPage, totalCount, currentPage+1);
		List<Room> rooms=this.roomService.queryByPage(roomPage);
		session.setAttribute("rooms", rooms);
		session.setAttribute("roomPage", roomPage);
		return "NextPage";
		
	}
	public String frontPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int totalCount=this.roomService.roomCounts();
		roomPage=PageUtil.createPage(everyPage, totalCount,currentPage-1);
		List<Room> rooms=this.roomService.queryByPage(roomPage);
		session.setAttribute("rooms", rooms);
		session.setAttribute("roomPage", roomPage);
		return "frontPage";
	}
}
