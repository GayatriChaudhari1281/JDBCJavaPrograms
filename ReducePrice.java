package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReducePrice {

	public static void main(String[] args) {
		int pid,amt,flag=0;
		try
		{
			pid=Integer.parseInt(args[0]);
			amt=Integer.parseInt(args[1]);
			String sql="update prod set price =price-"+amt+" where prodid="+pid;
			Statement st;
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlclass","root","root");
			st=con.createStatement();
			flag=st.executeUpdate(sql);
			if(flag>0)
			{
				System.out.println("Price updated succesfully");
				
			}
			else
				System.out.println("Invalid product id!!");
			st.close();
			con.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}

	}

}
