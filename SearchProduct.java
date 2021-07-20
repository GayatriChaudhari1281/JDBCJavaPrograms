package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchProduct {

	public static void main(String[] args) {
		String comp =args[0];
		String sql="select * from prod where company='"+comp+"'";
		try
		{
			Statement st;
			Connection con;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlclass","root","root");
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+  rs.getString(3)+ " " +rs.getInt(4));
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
