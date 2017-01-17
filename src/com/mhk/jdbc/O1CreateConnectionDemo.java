package com.mhk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class O1CreateConnectionDemo {

	public static void main(String a[]) throws Exception {
		Connection con =null;
		Statement stmt =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Naga_@12");
			 stmt = con.createStatement();
			System.out.println("Connection -------"+con);
			System.out.println("Statement---------"+stmt);
			System.out.println("Created DB Connection....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			stmt.close();
		}
	}
}
