package com.mhk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*JDBC PreparedStatement can be used when you plan to use the same SQL statement many times.
It is used to handle precompiled query.
If we want to execute same query with different values for more than one time then precompiled queries will reduce the no of compilations. 
Connection.prepareStatement() method can provide you PreparedStatment object. 
This object provides setXXX() methods to provide query values. 
Below example shows how to use PreparedStatement.*/
public class O6PreparedStatementDemo {
	 public static void main(String a[]){
         
	        Connection con = null;
	        PreparedStatement prSt = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.
	                getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>"
	                    ,"user","password");
	            String query = "insert into emp(name,salary) values(?,?)";
	            prSt = con.prepareStatement(query);
	            prSt.setString(1, "John");
	            prSt.setInt(2, 10000);
	            //count will give you how many records got updated
	            int count = prSt.executeUpdate();
	            //Run the same query with different values
	            prSt.setString(1, "Cric");
	            prSt.setInt(2, 5000);
	            count = prSt.executeUpdate();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally{
	            try{
	                if(prSt != null) prSt.close();
	                if(con != null) con.close();
	            } catch(Exception ex){}
	        }
	    }
	
}
