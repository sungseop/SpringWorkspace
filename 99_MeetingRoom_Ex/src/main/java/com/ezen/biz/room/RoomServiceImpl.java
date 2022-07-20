package com.ezen.biz.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.EquipmentDAO;
import com.ezen.biz.dao.RoomDAO;
import com.ezen.biz.dto.RoomVO;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDAO roomDao;
	
	@Autowired
	private EquipmentDAO eDao;
	
	@Override
	public int getMaxCapacity() {
		return roomDao.findMaxCapacity();
	}
	
	@Override
	public String getRoomNameById(String roomId) {
		return roomDao.findRoomNameById(roomId);
	}
	
	@Override
	public RoomVO getRoomById(String roomId) {
		return roomDao.getRoomById(roomId);
	}
	
	@Override
	public List<RoomVO> getAllRoom(){
		return roomDao.getAllRoom();
	}
	
	@Override
	public void insertRoom(RoomVO vo) {
		roomDao.insertRoom(vo);
		
		// RoomVO에 시설정보가 있으면 Equipment 테이블에 함께 insert
		if(vo.getEquipmentList() != null) {
			for(int i=0; i<vo.getEquipmentList().size(); i++) {
				eDao.insertEquipment(vo.getEquipmentList().get(i));
			}
		}
	}
	
	@Override
	public void updateRoom(RoomVO vo) {
		roomDao.updateRoom(vo);
	}
	
	@Override
	public void deleteRoom(RoomVO vo) {
		roomDao.deleteRoom(vo);
	}
}
