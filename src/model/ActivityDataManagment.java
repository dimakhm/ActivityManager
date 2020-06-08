package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Start.DBconncet;

public class ActivityDataManagment {

	
	public static void getOtherActivities() throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	             Statement st=conn.createStatement();  
	             ResultSet answer = st.executeQuery("select activityID, name, location, price, guide   from Activity where guide IS NOT NULL");
	             	
	             JTable table = new JTable(DBconncet.buildTableModel(answer));
	         	JOptionPane.showMessageDialog(null, new JScrollPane(table));
	           
	               

	             st.close();
	            

			}//end try

		finally {
			conn.close();
		}
		
	}// func end

	
	

	public static void getHighSchoolActivities() throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	             Statement st=conn.createStatement();  
	             ResultSet answer = st.executeQuery("select activityID, name, studyunits, profession, teacher   from Activity where studyunits IS NOT NULL");
	             	
	             JTable table = new JTable(DBconncet.buildTableModel(answer));
	         	JOptionPane.showMessageDialog(null, new JScrollPane(table));
	           
	               

	             st.close();
	            

			}//end try

		finally {
			conn.close();
		}
		
	}// func end

	
	public static void getElemntartActivities() throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	             Statement st=conn.createStatement();  
	             ResultSet answer = st.executeQuery("select activityID, name, profession, teacher,transport   from Activity where certification IS NOT NULL");
	             	
	             JTable table = new JTable(DBconncet.buildTableModel(answer));
	         	JOptionPane.showMessageDialog(null, new JScrollPane(table));
	           
	               

	             st.close();
	            

			}//end try

		finally {
			conn.close();
		}
		
	}// func end

	public static int deleteUserFromActivity(String email, int activityId) throws Exception
	{
		Connection conn=null;
//		Statement myStmt2 = null;
//		Statement myStmt = null;
//		Statement myStmt3 = null;
		ResultSet myRs1 = null;
		ResultSet myRs2 = null;
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	              
	             conn.createStatement();  
	             PreparedStatement st2=conn.prepareStatement(" select ACTIVITY_ID from USERinACTIVITY where (ACTIVITY_ID = (?)) ");
	             st2.setInt(1, activityId);
	             myRs2=st2.executeQuery();
	             
	             
	             
	             conn.createStatement();  
	             PreparedStatement st3=conn.prepareStatement(" select USER_EMAIL from USERinACTIVITY where (USER_EMAIL LIKE (?)) ");
	             st3.setString(1, email);
	             myRs1=st2.executeQuery();
	             
	             if ((myRs1.next() || myRs2.next()) == false )
	            	 return 0;

	             
	             
	             
	           conn.createStatement();  
	           // שאילתה שתביא לי את השורה המבוקשת
	           PreparedStatement st=conn.prepareStatement("DELETE FROM USERinACTIVITY WHERE USER_EMAIL LIKE (?) and (ACTIVITY_ID = (?))");
	            
	           st.setString(1,email);	
		       st.setInt(2, activityId);
		       st.executeUpdate();
		      		       
		      
		     			           
				}//end try
		finally {
			conn.close();
			
		}
		return 1;
		 
	}// func end

	
	
	// המימוש צריך לרוץ מ
	// activitydatamangment 
	// כי היא מפעילה דאטה בייס
	// מוחק פעילות ומטבלת פעילויות ומשתמשים מטבלת משתמשים ופעילויות
	public static int  deleteActivity(int activityId) throws Exception
	{
		Connection conn=null;
		ResultSet myRs1 = null;
		try {
							
						
			String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
			conn = DriverManager.getConnection(url);
			 PreparedStatement st3=conn.prepareStatement(" select ActivityID from Activity where (ActivityID = (?))");
			 st3.setInt(1, activityId); 
			 myRs1=st3.executeQuery();
			 if (myRs1.next()==false)
			 {
				 return 0;
			 }

							       	                         
	           // שאילתה שתביא לי את השורה המבוקשת
	           PreparedStatement st1=conn.prepareStatement("DELETE FROM Activity WHERE ActivityID LIKE (?)");
	           PreparedStatement st2=conn.prepareStatement("DELETE FROM USERinACTIVITY WHERE ACTIVITY_ID LIKE (?)");
		        
		       st1.setInt(1, activityId); 		            
		       st1.executeUpdate();
		       st2.setInt(1, activityId); 
		       st2.executeUpdate();
		      
		           
				}//end try
		finally {
			conn.close();
		}
		
		return 1;
	}// func end


	

	// מוחק ביקורת לפי מספר סידורי
	// חשוב להוסיף מס סידורי לדאטה בייס!!
		public static int deleteReview(int SerialNumber) throws Exception
		{
			ResultSet myRs1 = null;
			Connection conn=null;
			try {
				 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
		             conn = DriverManager.getConnection(url);
		             PreparedStatement st2 = conn.prepareStatement("select SerialNumber from RATING where (SerialNumber = (?))");
		             st2.setInt(1,SerialNumber); 	
		             myRs1=st2.executeQuery();
		             if (myRs1.next()==false)
					 {
						 return 0;
					 }
	       	                         
		           // שאילתה שתביא לי את השורה המבוקשת
		           PreparedStatement st1=conn.prepareStatement("DELETE FROM RATING  WHERE SerialNumber LIKE (?)");
		            
			        // פקודה למחיקת השורה שהתקבלה מהשאילתה
			       st1.setInt(1, SerialNumber); 		            
			       st1.executeUpdate();
			      
			       
			           
					}//end try
			finally
			{
				conn.close();
			}
		 return 1;
		}// func end


		
		

		public List<ReportDataManagment> getAllActivity() throws Exception 
		{
			Connection myConn=null;
			String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"; //"jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"
			myConn = DriverManager.getConnection(url);
	        
			List<ReportDataManagment> list = new ArrayList<>();
			
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("select Name from Activity group by name ");
				
				while (myRs.next())
				{
					ReportDataManagment tempEmployee = convertRowToUser(myRs);
					list.add(tempEmployee);
				}
				return list;
			}
			finally 
			{
				myConn.close();
				
			}
			
		}// func end
		


		
		
		
		private ReportDataManagment convertRowToUser(ResultSet myRs) throws Exception 
		{
			
	        String NAME = myRs.getString("NAME");
	        

	        ReportDataManagment tempReportDataManagment = new ReportDataManagment(NAME); 
	              

	        return tempReportDataManagment;
		}// func end
		
		
		
	
	
	
	
	
	
	
	
	
	
}//class end
