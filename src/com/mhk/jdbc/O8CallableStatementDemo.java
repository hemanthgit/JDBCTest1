package com.mhk.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*A CallableStatement object provides a way to call stored procedures using JDBC.
Connection.prepareCall() method provides you CallableStatement object. 
Below example shows how to call stored procedure.*/

/*
	CREATE PROCEDURE `EMP`.`getEmpName` 
	(IN EMP_ID INT, OUT EMP_FIRST VARCHAR(255))
	BEGIN
	SELECT first INTO EMP_FIRST
	FROM Employees
	WHERE ID = EMP_ID;
	END ;
*/

public class O8CallableStatementDemo {

	public static void main(String a[]) {

		Connection con = null;
		CallableStatement callSt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>", "user", "password");
			callSt = con.prepareCall("{call getEmpName(?,?)}");
			callSt.setInt(1, 200);
			callSt.setDouble(2, 3000);
			callSt.execute();
			System.out.println("Executed stored procedure!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (callSt != null)
					callSt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}
}
