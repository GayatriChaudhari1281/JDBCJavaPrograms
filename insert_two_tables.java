package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert_two_tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cname,caddr,cphno,cpass,cid;
		try
		{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("Enter customer id");
			cid=br.readLine();
			System.out.println("Enter customer name");
			cname=br.readLine();
			System.out.println("Enter customer address");
			caddr=br.readLine();
			System.out.println("Enter customer phone number");
			cphno=br.readLine();
			System.out.println("Enter customer password");
			cpass=br.readLine();
			String sql1="insert into customer values('"+cid+"','"+cname+"','"+caddr+"','"+cphno+"')";
			String sql2="insert into user values('"+cid+"','"+cpass+"')";
			
			Statement st;
			Connection con;
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlclass","root","root");
			st=con.createStatement();
			st.executeUpdate(sql1);
			System.out.println("Customer Registered succesfully");
	
			st.executeUpdate(sql2);
			System.out.println("Login id for customer is created");
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
	}

}
