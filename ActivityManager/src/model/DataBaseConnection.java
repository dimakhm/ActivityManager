package model;

import java.sql.*;

public class DataBaseConnection {
	
    private static DataBaseConnection dataBaseConnection ; 

    Connection conn = null;
	String url;	

	public static DataBaseConnection getConnection() 
    { 
        if (dataBaseConnection == null) 
        	dataBaseConnection = new DataBaseConnection(); 
  
        return dataBaseConnection; 
    } 
	
	 private DataBaseConnection() {
	        try {
	           this.url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	       
	        
	
	  }
	  
	 
	 
	 
	 
	 
	 
	 
//	 public void close(Connection myConn, Statement myStmt, ResultSet myRs)
//				throws SQLException {
//
//			if (myRs != null) {
//				myRs.close();
//			}
//
//			if (myStmt != null) {
//				
//			}
//			
//			if (myConn != null) {
//				myConn.close();
//			}
//		}
//
//		private void close(Statement myStmt, ResultSet myRs) throws SQLException {
//			close(null, myStmt, myRs);		
//		}
	 
	 
	  
	  
	  
}//class end



