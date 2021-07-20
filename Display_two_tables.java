package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Display_two_tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement st;
		Connection con;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlclass","root","root");
			st=con.createStatement();
			rs=st.executeQuery("select * from customer");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"			"+rs.getString(2)+"			"+  rs.getString(3)+ "			" +rs.getString(4));
			}
			rs.close();
			rs=st.executeQuery("select * from user");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"         "+  rs.getString(2));
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
