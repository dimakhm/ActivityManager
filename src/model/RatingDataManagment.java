package model;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Start.DBconncet;
import view.RatingAndReview;

public class RatingDataManagment {

	public static void insertRatingAndReview(RatingAndReview input) throws Exception
	{
	Connection conn=null;
	
	try {
		 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("INSERT INTO RATING (ActivityID,review,rating) VALUES (?,?,?)");
	            st.setInt(1, input.getActivityID());
	            st.setString(2, input.getReview());
	            st.setDouble(3, input.getRating());

	            st.executeUpdate();
	           
	           
			}//end try

		finally {
			conn.close();
		}
	
	
}
	
	
	public static void showRatingAndReview(int activityID) throws Exception
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	           
	           

		            PreparedStatement st=conn.prepareStatement("select review,rating from RATING Where activityID=?");
		            st.setInt(1, activityID);
		            
		            ResultSet answer = st.executeQuery();
	             
	            
	             JTable table = new JTable(DBconncet.buildTableModel(answer));
	         	  JOptionPane.showMessageDialog(null, new JScrollPane(table));
	           
	               

	             st.close();
	            

			}//end try

		finally {
			conn.close();
		}
		
	}// func end
	
	
}
