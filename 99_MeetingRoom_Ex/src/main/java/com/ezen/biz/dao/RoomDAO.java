package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;

@Repository("roomDao")
public class RoomDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EquipmentDAO eDao;
	
	// sql문
	private static final String SELECT_MAX_CAPACITY = "SELECT MAX(capacity) FROM room";
	private static final String GET_ROOM_NAME = "SELECT room_name FROM room WHERE room_id=?";
	private static final String GET_ROOM_INFO = "SELECT * FROM room WHERE room_id=?";
	private static final String GET_ALL_ROOM = "SELECT * FROM room ORDER BY room_name";
	private static final String INSERT_ROOM = "INSERT INTO room VALUES(?, ?, ?)";
	private static final String UPDATE_ROOM = "UPDATE room SET room_name=?, capacity=? WHERE room_id=?";
	private static final String DELETE_ROOM = "DELETE FROM room WHERE room_id=?";
	
	// 회의실 최대 수용인원 조회
	public int findMaxCapacity() {
		// 조회 결과를 정수로 리턴받는 경우
		return jdbcTemplate.queryForObject(SELECT_MAX_CAPACITY, Integer.class);
	}
	
	// 회의실 번호를 조건으로 회의실 명 조회
	public String findRoomNameById(String roomId) {
		Object[] args = {roomId};
		
		return jdbcTemplate.queryForObject(GET_ROOM_NAME, args, String.class);
	}
	
	// 회의실 번호를 조건으로 회의실 정보 조회
	public RoomVO getRoomById(String roomId) {
		Object[] args = {roomId};
		
		RoomVO room = jdbcTemplate.queryForObject(GET_ROOM_INFO, args, new RoomRowMapper());
		
		// 부대시설 정보 조회
		List<EquipmentVO> equipList = eDao.getEquipmentByRoomid(roomId);
		room.setEquipmentList(equipList);
		
		return room;
	}
	
	// 모든 회의실 정보 조회
	public List<RoomVO> getAllRoom(){
		return jdbcTemplate.query(GET_ALL_ROOM, new RoomRowMapper());
	}
	
	// 회의실 정보 저장
	public void insertRoom(RoomVO room) {
		Object[] args = {room.getRoom_id(), room.getRoom_name(), room.getCapacity()};
		
		jdbcTemplate.update(INSERT_ROOM, args);
	}
	
	// 회의실 정보 수정 // 리턴값: 수정된 행의 수
	public int updateRoom(RoomVO room) {
		Object[] args = {room.getRoom_name(), room.getCapacity(), room.getRoom_id()};
		
		return jdbcTemplate.update(UPDATE_ROOM, args);
	}
	
	// 회의실 정보 삭제 // 리턴값: 수정된 행의 수
	public int deleteRoom(RoomVO room) {
		Object[] args = {room.getRoom_id()};
		
		return jdbcTemplate.update(DELETE_ROOM, args);
	}
	
	class RoomRowMapper implements RowMapper<RoomVO>{

		@Override
		public RoomVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoomVO room = new RoomVO();
			
			room.setRoom_id(rs.getString("room_id"));
			room.setRoom_name(rs.getString("room_name"));
			room.setCapacity(rs.getInt("capacity"));
			
			return room;
		}
		
	}
}
