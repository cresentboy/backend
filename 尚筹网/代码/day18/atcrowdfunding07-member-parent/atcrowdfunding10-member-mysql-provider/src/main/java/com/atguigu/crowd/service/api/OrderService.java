package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;

public interface OrderService {

	OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

	List<AddressVO> getAddressVOList(Integer memberId);

	void saveAddress(AddressVO addressVO);

}
