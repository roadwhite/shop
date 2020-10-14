package com.roadwhite.shop.mapper;

import java.util.List;

import com.roadwhite.shop.entity.Shop;
import com.roadwhite.shop.entity.order;

public interface ShopMapper {
	List<Shop> query();
	int insert(Shop shop);
	List<order> queryOrder();
	int updateorder(order o);
}
