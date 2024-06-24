package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.demo.model.Details;
import com.demo.util.ConnectionUtil;


public class DetailsImpl {
	public static void learnerdetails(Details insert) throws ClassNotFoundException,SQLException
	   {   
		  
		   Connection con=ConnectionUtil.getConnection();
		   String query="insert into users (name,email,password)values(?,?,?)";
		   PreparedStatement p = con.prepareStatement(query);
		   p.setString(1,insert.getName());
		   p.setString(2,insert.getEmail() );
		   p.setString(3, insert.getPassword());
		   p.executeUpdate();
	   }
	public List<Details> get() throws ClassNotFoundException, SQLException {
	      List<Details> questions = new ArrayList<Details>();
	      Details insert=new Details();
	      Connection con=ConnectionUtil.getConnection();
	    String query = "SELECT * FROM users";
	    PreparedStatement p = con.prepareStatement(query);
	    ResultSet re = p.executeQuery();
	   
	    while (re.next()) {
	        Details question = new Details();
	        question.setId(re.getInt("id"));
	        question.setName(re.getString("name"));
	        question.setEmail(re.getString("email"));
	        question.setPassword(re.getString("password"));
	        questions.add(question);
	    }
		return questions;
	    
	}
}
