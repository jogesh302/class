package com.mtc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mtc.vo.Items;

public class ItemsDAO extends BaseDAO implements IItemsDAO{

	@Override
	public void add(Items items) {
	
		String insertQuery = "insert into sample.items(items_id,items_name,items_price,items_description)"
				+ "values(?,?,?,?)";
		                //1,2,3,4
		
		try (Connection connection = getConnection() ){			
			
			//Step2 : Create a prepared statement object to execute the query
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			//Step3 : Assign the data which is in the product object to the bind parameters in the query
			preparedStatement.setInt(1,items.getId());
			preparedStatement.setString(2,items.getName());
			preparedStatement.setFloat(3,items.getPrice());
			preparedStatement.setString(4,items.getDescribtion());
			
			int noOfRowsUpdated = preparedStatement.executeUpdate();
			
			if(noOfRowsUpdated == 1) {
				System.out.println("Record added successfully");
			}		
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Items findById(int id) {

		String selectQuery = "select * from test.product where product_id=?";
		
		Items items = new Items();
		
		try(Connection connection = getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setInt(1,id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				 items = toItems(resultSet);				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;


	}

	@Override
	public List<Items> findAll() {

		String selectQuery = "select * from sample.items";
		
		List<Items> itemsList = new ArrayList<>();
		
		try(Connection connection = getConnection()){
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()) {	
				
				itemsList.add(toItems(resultSet));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return itemsList;

	}

	@Override
	public void update(Items items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private Items toItems(ResultSet resultSet) {
		Items items = new Items();
		try {
			items.setId(resultSet.getInt("item_id"));				
			items.setName(resultSet.getString("item_name"));				
			items.setPrice(resultSet.getFloat("item_price"));
			items.setDescribtion(resultSet.getString("item_description"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	}

}

