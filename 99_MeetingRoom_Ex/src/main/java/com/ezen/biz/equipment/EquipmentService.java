package com.ezen.biz.equipment;

import com.ezen.biz.dto.EquipmentVO;

public interface EquipmentService {

	void insertEquipment(EquipmentVO vo);
	
	public void updateEquipment(EquipmentVO vo);
	
	public void deleteEquipment(EquipmentVO vo);

}