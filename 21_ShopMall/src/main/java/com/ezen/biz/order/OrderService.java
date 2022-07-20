package com.ezen.biz.order;

import java.util.List;

import com.ezen.biz.dto.OrderVO;

public interface OrderService {

	int getMaxOseq();

	/*
	 * 주문하기 처리
	 * - 주문 저장후 주문번호를 반환한다.
	 */
	int insertOrder(OrderVO vo);

	/*
	 * 주문상세 내역 저장
	 */
	void insertOrderDetail(OrderVO vo);

	List<OrderVO> getListOrderById(OrderVO vo);

	List<Integer> getSeqOrdering(OrderVO vo);

}