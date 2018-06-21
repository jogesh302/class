package com.mtc.dao;

import java.util.List;

import com.mtc.vo.Items;

public interface IItemsDAO {
	
	void add(Items items);
	Items findById(int id);
	List<Items> findAll();
	void update(Items items);
	void delete(int id);

}