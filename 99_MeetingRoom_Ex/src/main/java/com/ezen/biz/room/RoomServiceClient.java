package com.ezen.biz.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.EquipmentVO;
import com.ezen.biz.dto.RoomVO;
import com.ezen.biz.equipment.EquipmentService;

public class RoomServiceClient {
	
	private static RoomService roomService = null;
	private static EquipmentService eqService = null;
	
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		roomService = (RoomService)container.getBean("roomService");
		eqService = (EquipmentService)container.getBean("equipmentService");
		
		RoomVO room = roomService.getRoomById("A001");
		printRoom(room);
		
		// B004 ȸ�ǽǿ� ��ġ�� ���� ���� �� ����
		EquipmentVO eVo1 = new EquipmentVO();
		eVo1.setEquipment_id("50-1");
		eVo1.setRoom_id("B004");
		eVo1.setEquipment_name("ȸ�ǿ� TABLE");
		eVo1.setEquipment_count(1);
		eVo1.setEquipment_remarks("ȸ�ǿ� ���̺�");
		eqService.updateEquipment(eVo1);
		
		EquipmentVO eVo2 = new EquipmentVO();
		eVo2.setEquipment_id("50-2");
		eqService.deleteEquipment(eVo2);
		
		// ���� ����, ���� Ȯ��
		room = roomService.getRoomById("B004");
		printRoom(room);
		
		// ���ο� ȸ�ǽ� �߰�
		//addRoomAndEquipment();
		
		//roomService.insertRoom(vo1);
		
		printAllRoom();
		
		// ȸ�ǽ� ���� ����
		/*
		RoomVO vo1 = new RoomVO();
		vo1.setRoom_id("B003");
		vo1.setRoom_name("��ȸ�ǽ�");
		vo1.setCapacity(5);
		roomService.updateRoom(vo1);
		System.out.println("<< ���� �� ȸ�ǽ� ��� >>");
		printAllRoom();
		*/
		
		container.close();
	}
	
	public static void printRoom(RoomVO vo) {
		System.out.println("<< ȸ�ǽ� ���� >>");
		System.out.println(vo);
		System.out.println("<< �δ�ü� ���� >>");
		if(vo.getEquipmentList() != null) {
			List<EquipmentVO> eList = vo.getEquipmentList();
			for(int i=0; i<eList.size(); i++) {
				System.out.println(eList.get(i));
			}
		}
	}
	
	public static void printAllRoom() {
		// ��� ȸ�ǽ� ���� ���
		List<RoomVO> roomList = roomService.getAllRoom();
		System.out.println("<< ��� ȸ�ǽ� ���� >>");
		for(RoomVO vo : roomList) {
			System.out.println(vo);
		}
	}
	
	public static void addRoomAndEquipment() {
		// ���ο� ȸ�ǽ� �߰�
		RoomVO vo1 = new RoomVO();
		vo1.setRoom_id("B004");
		vo1.setRoom_name("�湮�� ȸ�ǽ�");
		vo1.setCapacity(5);
		
		List<EquipmentVO> eList = new ArrayList<EquipmentVO>();
		
		EquipmentVO eVO1 = new EquipmentVO();
		eVO1.setEquipment_id("50-1");
		eVO1.setEquipment_name("ȸ�ǿ� ���̺�");
		eVO1.setEquipment_count(1);
		eVO1.setEquipment_remarks("6�ο� ȸ�� ���̺�");
		eVO1.setRoom_id("B004");
		eList.add(eVO1);
		
		EquipmentVO eVO2 = new EquipmentVO();
		eVO2.setEquipment_id("50-2");
		eVO2.setEquipment_name("���̺� ����");
		eVO2.setEquipment_count(6);
		eVO2.setEquipment_remarks("ȸ�� ���̺� ����");
		eVO2.setRoom_id("B004");
		eList.add(eVO2);
		
		//ȸ�ǽ� ��� ��Ͽ� ���ο� ��� �߰�
		vo1.setEquipmentList(eList);
		
		roomService.insertRoom(vo1); // room, equipment ���̺� ���ο� �� �߰�
	}
}