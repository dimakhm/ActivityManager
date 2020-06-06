package model;

import java.sql.*;

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

	
	
	
	
	
	
	
	
	
	
	
}//class end
