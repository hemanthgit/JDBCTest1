package com.mhk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*This example shows how to update table records using SQL update query.
By using Statement.executeUpdate()you can execute update statements.
Statement.executeUpdate()method returns you number of records got updated.*/

public class O4UpdateDemo {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			stmt = con.createStatement();
			String query = "update emp set sal=3000 where empno in(7499,7521)";
			// count will give you how many records got updated
			int count = stmt.executeUpdate(query);
			System.out.println("Updated queries: " + count);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}
}
