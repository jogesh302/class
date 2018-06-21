package com.mtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mtc.vo.User;

public class UserDAO extends BaseDAO{
	
	public User loadByUsername(String username) {
		
		User user = null;
		
		String query = "select * from test.registereduser where username = ?";
		
		try(Connection connection = getConnection()){
		
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,username);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){	
					
					user = new User();
					user.setFirstname(resultSet.getString("first_name"));
					user.setLastname(resultSet.getString("last_name"));
					user.setUsername(resultSet.getString("username"));
					user.setCity(resultSet.getString("city"));
					user.setEmail(resultSet.getString("email"));
					user.setGender(resultSet.getString("gender"));
					user.setPassword(resultSet.getString("password"));
					
					System.out.println("UserDAO : Username : "+user.getUsername()+" Password: "+user.getPassword());
					
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}

