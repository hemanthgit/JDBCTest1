package com.mhk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
ResultSetMetaData is an object that can be used to get information about the types and properties of the columns in a ResultSet object. 
Below example shows how to get ResultSet column properties using ResultSetMetaData object.
*/
public class O10ResultsetMetadata {

	public static void main(String a[]) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>", "user", "password");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 0; i <= columnCount; i++) {
				System.out.println(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnType(i));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}
}
