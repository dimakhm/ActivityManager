package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import view.OtherActivity;
import view.User;

public class ActivityRepository {

DataBaseConnection connection ;	

	
public ActivityRepository()
	{
		this.connection=DataBaseConnection.getConnection();
	}
	
	
	

	

public List<OtherActivity> getOtherActivity() throws Exception {

	List<OtherActivity> list = new ArrayList<>();

	
	
	
    connection.conn = DriverManager.getConnection(connection.url);
    

try {
	
	Statement myStmt = connection.conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("select activityID, name, location,CurrentCap,MaxCap, price,Description,Guide,Category,AgeRange   from Activity where guide IS NOT NULL");

          
	while (myRs.next()) {
		OtherActivity tempEmployee = convertRowToOtherActivity(myRs);
		list.add(tempEmployee);
		
	}   
          
	return list;	  
        
         

	}//end try

finally {
	connection.conn.close();
}

}// func end	







public OtherActivity convertRowToOtherActivity(ResultSet myRs) throws SQLException {
		
	    int activityID = myRs.getInt("ActivityID");
		  String name= myRs.getString("Name");
		  String location= myRs.getString("Location");
		  int currentCapicity= myRs.getInt("CurrentCap");
		  int maxCapicity= myRs.getInt("MaxCap");
		  double price= myRs.getInt("Price");
		  String description= myRs.getString("Description");
		  String guide= myRs.getString("Guide");
		 String category= myRs.getString("Category");
		 String ageRange= myRs.getString("AgeRange");
		
		OtherActivity temp = new OtherActivity(activityID,name, location, currentCapicity,maxCapicity,price,description,guide,category,ageRange);
		
		return temp;
	}

	

public void RegisterUserToAvctivity(User user,int activityID) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);

try {
               
            PreparedStatement st=  connection.conn.prepareStatement("INSERT INTO USERinACTIVITY (USER_EMAIL,ACTIVITY_ID) VALUES (?,?)");
            st.setString(1, user.getEmail());
            st.setInt(2, activityID);
			
            st.executeUpdate();
           
           
		}//end try

	finally {
		  connection.conn.close();
	}


}
	
	

public  int capicityByActivity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	
	try {
		
            
            PreparedStatement st=connection.conn.prepareStatement("select maxcap-currentcap from Activity where ActivityID=?");
            st.setInt(1, activityId);
            ResultSet answer = st.executeQuery();
           
            while(answer.next())
            {
            	
            	int cap=answer.getInt(1);
            	

				return cap;		
            
            }
            

		}//end try

	finally {
		connection.conn.close();
	}
	return -1;	
}

public  void incrementCapicity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	
	try {
		
           
            
            PreparedStatement st=connection.conn.prepareStatement("UPDATE Activity SET currentcap = currentcap + 1 WHERE activityid = ?");
            st.setInt(1, activityId);
           st.execute();
           
            

		}//end try

	finally {
		connection.conn.close();
	}
}


public  void reduceCapicity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	
	try {
		
            
            PreparedStatement st= connection.conn.prepareStatement("UPDATE Activity SET currentcap = currentcap - 1 WHERE activityid = ?");
            st.setInt(1, activityId);
           st.execute();
           
            

		}//end try

	finally {
		 connection.conn.close();
	}
}
	



public int  deleteActivity(int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);

	try {
						

		 PreparedStatement st3=connection.conn.prepareStatement(" select ActivityID from Activity where (ActivityID = (?))");
		 st3.setInt(1, activityId); 
		 ResultSet myRs1=st3.executeQuery();
		 if (myRs1.next()==false)
		 {
			 return 0;
		 }

						       	                         
           // שאילתה שתביא לי את השורה המבוקשת
           PreparedStatement st1=connection.conn.prepareStatement("DELETE FROM Activity WHERE ActivityID LIKE (?)");
           PreparedStatement st2=connection.conn.prepareStatement("DELETE FROM USERinACTIVITY WHERE ACTIVITY_ID LIKE (?)");
	        
	       st1.setInt(1, activityId); 		            
	       st1.executeUpdate();
	       st2.setInt(1, activityId); 
	       st2.executeUpdate();
	      
	           
			}//end try
	finally {
		connection.conn.close();
	}
	
	return 1;
}// func end



public int deleteUserFromActivity(String email, int activityId) throws Exception
{
    connection.conn = DriverManager.getConnection(connection.url);
	ResultSet myRs1 = null;
	ResultSet myRs2 = null;
	try {
		
              
		connection.conn.createStatement();  
             PreparedStatement st2=connection.conn.prepareStatement(" select ACTIVITY_ID from USERinACTIVITY where (ACTIVITY_ID = (?)) ");
             st2.setInt(1, activityId);
             myRs2=st2.executeQuery();
             
             
             
             connection.conn.createStatement();  
             PreparedStatement st3=connection.conn.prepareStatement(" select USER_EMAIL from USERinACTIVITY where (USER_EMAIL LIKE (?)) ");
             st3.setString(1, email);
             myRs1=st2.executeQuery();
             
             if ((myRs1.next() || myRs2.next()) == false )
            	 return 0;

             
             
             
             connection.conn.createStatement();  
           // שאילתה שתביא לי את השורה המבוקשת
           PreparedStatement st=connection.conn.prepareStatement("DELETE FROM USERinACTIVITY WHERE USER_EMAIL LIKE (?) and (ACTIVITY_ID = (?))");
            
           st.setString(1,email);	
	       st.setInt(2, activityId);
	       st.executeUpdate();
	      		       
	      
	     			           
			}//end try
	finally {
		connection.conn.close();
		
	}
	return 1;
	 
}// func end





	
	
}
