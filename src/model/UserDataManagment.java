package model;

import java.sql.*;

import controller.User;

public class UserDataManagment {

	public static void RegisterUserToAvctivity(User user,int activityID) throws Exception
	{
	Connection conn=null;
	
	try {
		 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("INSERT INTO USERinACTIVITY (USER_EMAIL,ACTIVITY_ID) VALUES (?,?)");
	            st.setString(1, user.getEmail());
	            st.setInt(2, activityID);
				
	            st.executeUpdate();
	           
	           
			}//end try

		finally {
			conn.close();
		}
	
	
}

	
}

