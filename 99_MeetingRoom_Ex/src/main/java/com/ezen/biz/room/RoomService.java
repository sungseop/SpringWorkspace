package com.ezen.biz.room;

import java.util.List;

import com.ezen.biz.dto.RoomVO;

public interface RoomService {

	int getMaxCapacity();

	String getRoomNameById(String roomId);

	RoomVO getRoomById(String roomId);
	
	List<RoomVO> getAllRoom();

	void insertRoom(RoomVO vo);
	
	void updateRoom(RoomVO vo);
	
	void deleteRoom(RoomVO vo);
}