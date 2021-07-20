package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteProd {

	public static void main(String[] args) {
		int pid,flag=0;
		try
		{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br =new BufferedReader(isr);
			System.out.println("Enter Product Id:");
			pid=Integer.parseInt(br.readLine());
			
			String sql="delete from prod where prodid="+pid;
			
			Statement st;
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlclass","root","root");
			st=con.createStatement();
			flag=st.executeUpdate(sql);
			if(flag>0)
			{
				System.out.println("product data deleted succesfully");
				
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
