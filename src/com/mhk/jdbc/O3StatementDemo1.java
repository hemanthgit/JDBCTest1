package com.mhk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class O3StatementDemo1 {

	public static void main(String a[]){
         
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
					"tiger");
            Statement stmt = con.createStatement();
            System.out.println("Created DB Connection....");
            ResultSet rs = stmt.executeQuery("select ename, sal from emp");
            while(rs.next()){
                System.out.print(rs.getString("ename")+"------");
                System.out.println(rs.getInt("sal"));
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
