package com.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDemo {
	public final static String CONN_URL="jdbc:mysql://localhost:3306/hibernate";
	public final static String USER="root";
	public final static String PASSWORD="1qaz@WSX";
	public final static String QUERY_USER="select * from user";
	public final static String ADD_USER="insert into user(username,userage,password,compaddress) values('ls',25,'Pass@word','gsyh')";
	
	private Connection connection;
	private Statement createStatement;
	private ResultSet executeQuery; 
	private int num;
	private void add() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(CONN_URL,USER,PASSWORD);
			connection.setAutoCommit(false);
			createStatement = connection.createStatement();
			num=createStatement.executeUpdate(ADD_USER);
			System.out.println(num);
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}finally {
				 try {
						 if(createStatement!=null) createStatement.close();
						 if(connection!=null)  	   connection.close(); 
					} catch (SQLException e) {
						e.printStackTrace();
					}
				 }
				
		}
			
		
	
	public static void main(String[] args) {
		new JdbcDemo().add();
	}

}
