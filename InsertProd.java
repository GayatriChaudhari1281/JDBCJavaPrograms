package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertProd {

	public static void main(String[] args) throws IOException{
		int pid,price;
		String pname, comp;
		try
		{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br =new BufferedReader(isr);
			System.out.println("Enter Product Id:");
			pid=Integer.parseInt(br.readLine());
			System.out.println("Enter Product name:");
			pname=br.readLine();
			System.out.println("Enter Product company:");
			comp=br.readLine();
			System.out.println("Enter Product price:");
			price=Integer.parseInt(br.readLine());
			String sql="insert into prod values("+pid+",'"+pname+"','"+comp+"',"+price+")";
			
			Statement st;
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlclass","root","root");
			st=con.createStatement();
			st.executeUpdate(sql);
			System.out.println("Product data added succesfully!!");
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}

	}


}
