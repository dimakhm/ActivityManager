package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Start.DBconncet;
import view.ElementarySchoolActivity;
import view.HighSchoolActivity;
import view.OtherActivity;

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

	public static void incrementCapicity(int activityId) throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("UPDATE Activity SET currentcap = currentcap + 1 WHERE activityid = ?");
	            st.setInt(1, activityId);
	           st.execute();
	           
	            

			}//end try

		finally {
			conn.close();
		}
	}

	
	public static void reduceCapicity(int activityId) throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("UPDATE Activity SET currentcap = currentcap - 1 WHERE activityid = ?");
	            st.setInt(1, activityId);
	           st.execute();
	           
	            

			}//end try

		finally {
			conn.close();
		}
	}
		
	
	
	
	public static int capicityByActivity(int activityId) throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("select maxcap-currentcap from Activity where ActivityID=?");
	            st.setInt(1, activityId);
	            ResultSet answer = st.executeQuery();
	           
	            while(answer.next())
	            {
	            	
	            	int cap=answer.getInt(1);
	            	

	            	
					return cap;		
	            
	            }
	            

			}//end try

		finally {
			conn.close();
		}
		return -1;	
	}
		
		
	public static int getActivityType(int activityId) throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("select type from Activity where activityid=?");
	            st.setInt(1, activityId);
	            ResultSet answer = st.executeQuery();
	           
	            while(answer.next())
	            {
	            	
	            	int type=answer.getInt(1);
	            	

	            	
					return type;		
	            
	            }
	            

			}//end try

		finally {
			conn.close();
		}
		return -1;	
	}
	

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
		
		
		public static void addElamentryShcoolActivity(ElementarySchoolActivity Other) throws Exception {
			
			Connection conn=null;
			//ResultSet myRs = null;

			try {
				 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
		             conn = DriverManager.getConnection(url);

			            
			            PreparedStatement st=conn.prepareStatement("INSERT INTO Activity (activityID, name, location, currentCap, maxCap, price, description, certification, transport, access, type)"
			            		+ " VALUES (?,?,?,0,?,?,?,?,?,?,3)");
			            st.setInt(1,  Other.getActivityID());
			            st.setString(2, Other.getName());
			            st.setString(3, Other.getLocation());
			            st.setInt(4, Other.getMaxCapicity()); 
			            st.setDouble(5, Other.getPrice());
			            st.setString(6, Other.getDescription()); 
			            st.setString(7, Other.getCertification());
			            st.setString(8, Other.getTransport());  
			            st.setString(9, Other.getAccessable());
			          
			          	 st.executeUpdate();
					//	 if (myRs.next()==false)
					//	 {
					//		 return 0;
					//	 }
					}//end try

				finally {
					conn.close();
		}
			JOptionPane.showMessageDialog(null, "Activity created successfully!");
			
			}// func end
		
		public static void addHighSchoolActivity(HighSchoolActivity Other) throws Exception {
			
			Connection conn=null;
			//ResultSet myRs = null;
			try {
				 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
		             conn = DriverManager.getConnection(url);

			            
			            PreparedStatement st=conn.prepareStatement("INSERT INTO Activity (activityID, name, location, currentCap, maxCap, price, description, StudyUnits, FinalExam, SchoolAss, type)"
			            		+ " VALUES (?,?,?,0,?,?,?,?,?,?,2)");
			            st.setInt(1,  Other.getActivityID());
			            st.setString(2, Other.getName());
			            st.setString(3, Other.getLocation());
			            st.setInt(4, Other.getMaxCapicity()); 
			            st.setDouble(5, Other.getPrice());
			            st.setString(6, Other.getDescription()); 
			            st.setInt(7, Other.getStudyUnits());
			            st.setString(8, Other.getFinalExam());  
			            st.setString(9, Other.getSchoolAssociation());
			          
			            st.executeUpdate();
					// if (myRs.next()==false)
					// {
					//	 return 0;
					// }
					}//end try

				finally {
					conn.close();
				}
			JOptionPane.showMessageDialog(null, "Activity created successfully!");
			//return 1;
			}// func end
		public static void addOtherActivity(OtherActivity Other) throws Exception {
			
			Connection conn=null;
			//ResultSet myRs = null;
			try {
				 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
		             conn = DriverManager.getConnection(url);
			           
			            
			            PreparedStatement st=conn.prepareStatement("INSERT INTO Activity (activityID, name, location, currentCap, maxCap, price, description, guide, category, ageRange, type)"
			            		+ " VALUES (?,?,?,0,?,?,?,?,?,?,1)");
			            st.setInt(1,  Other.getActivityID());
			            st.setString(2, Other.getName());
			            st.setString(3, Other.getLocation());
			            st.setInt(4, Other.getMaxCapicity()); 
			            st.setDouble(5, Other.getPrice());
			            st.setString(6, Other.getDescription()); 
			            st.setString(7, Other.getGuide());
			            st.setString(8, Other.getCategory());  
			            st.setString(9, Other.getAgeRange());
      		           

			            st.executeUpdate();

					//	 if (myRs.next()==false)
					//	 {
					//		 return 0;
					//	 }
					}//end try

				finally {
					conn.close();
		}
			JOptionPane.showMessageDialog(null, "Activity created successfully!");

	//	return 1;
	}// func end		
	
	
	
	
	
	
	
	
	
}//class end
