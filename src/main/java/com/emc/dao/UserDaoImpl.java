package com.emc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.emc.userregistrations.User;



@Repository
public class UserDaoImpl implements UserDao{
	
	
	public User getUserDetails(String userId) {
		
		User user = new User();
		String connectionURL = "jdbc:oracle:thin:@localhost:1521";
		
		Connection con = null;
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    con = DriverManager.getConnection (connectionURL,"system","chinni");
		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from userregistration where id="+userId);
		 
		    while (rs.next()){
		        user.setUserId(rs.getString("id"));
		        user.setUserGender(rs.getString("gender"));
		        user.setUserName(rs.getString("name"));
		        user.setUserStatus(rs.getString("status"));
		        user.setUserPhoneNum(rs.getString("PhoneNum"));
		        user.setUserMailID(rs.getString("MailID"));
		}
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		finally {
		    try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	public String saveUserDetails(User user) {
		String connectionURL = "jdbc:oracle:thin:@localhost:1521";
		
		Connection con = null;
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    con = DriverManager.getConnection (connectionURL,"system","chinni");
		    Statement stmt = con.createStatement();
		    int i = stmt.executeUpdate("insert into userregistration values ('"+user.getUserId()+"','"+user.getUserName()+"','"+user.getUserGender()+"','"+user.getUserStatus()+"','"+user.getUserPhoneNum()+"''"+user.getUserMailID()+"')");
		    System.out.println("Succeded !");
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		finally {
		    try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user.getUserId();
	}

	
	
	
	
}
