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
	
	// sql��
	private static final String SELECT_MAX_CAPACITY = "SELECT MAX(capacity) FROM room";
	private static final String GET_ROOM_NAME = "SELECT room_name FROM room WHERE room_id=?";
	private static final String GET_ROOM_INFO = "SELECT * FROM room WHERE room_id=?";
	private static final String GET_ALL_ROOM = "SELECT * FROM room ORDER BY room_name";
	private static final String INSERT_ROOM = "INSERT INTO room VALUES(?, ?, ?)";
	private static final String UPDATE_ROOM = "UPDATE room SET room_name=?, capacity=? WHERE room_id=?";
	private static final String DELETE_ROOM = "DELETE FROM room WHERE room_id=?";
	
	// ȸ�ǽ� �ִ� �����ο� ��ȸ
	public int findMaxCapacity() {
		// ��ȸ ����� ������ ���Ϲ޴� ���
		return jdbcTemplate.queryForObject(SELECT_MAX_CAPACITY, Integer.class);
	}
	
	// ȸ�ǽ� ��ȣ�� �������� ȸ�ǽ� �� ��ȸ
	public String findRoomNameById(String roomId) {
		Object[] args = {roomId};
		
		return jdbcTemplate.queryForObject(GET_ROOM_NAME, args, String.class);
	}
	
	// ȸ�ǽ� ��ȣ�� �������� ȸ�ǽ� ���� ��ȸ
	public RoomVO getRoomById(String roomId) {
		Object[] args = {roomId};
		
		RoomVO room = jdbcTemplate.queryForObject(GET_ROOM_INFO, args, new RoomRowMapper());
		
		// �δ�ü� ���� ��ȸ
		List<EquipmentVO> equipList = eDao.getEquipmentByRoomid(roomId);
		room.setEquipmentList(equipList);
		
		return room;
	}
	
	// ��� ȸ�ǽ� ���� ��ȸ
	public List<RoomVO> getAllRoom(){
		return jdbcTemplate.query(GET_ALL_ROOM, new RoomRowMapper());
	}
	
	// ȸ�ǽ� ���� ����
	public void insertRoom(RoomVO room) {
		Object[] args = {room.getRoom_id(), room.getRoom_name(), room.getCapacity()};
		
		jdbcTemplate.update(INSERT_ROOM, args);
	}
	
	// ȸ�ǽ� ���� ���� // ���ϰ�: ������ ���� ��
	public int updateRoom(RoomVO room) {
		Object[] args = {room.getRoom_name(), room.getCapacity(), room.getRoom_id()};
		
		return jdbcTemplate.update(UPDATE_ROOM, args);
	}
	
	// ȸ�ǽ� ���� ���� // ���ϰ�: ������ ���� ��
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
