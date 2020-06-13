
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JOptionPane;

import java.io.BufferedWriter;

import java.io.FileWriter;
 

//import javax.swing.JOptionPane;

// כל תפקיד המחלקה לספק דוח שהוא הנתונים מהטבלה של המשתמשים-text1 
public class ReportDataManagment
{

	public String EMAIL;
	public String NAME;
	public String PHONE;
	public String PASS;
	

	
	public ReportDataManagment()
	{
		
	}
	
	public ReportDataManagment(String name)
	{
		this.NAME= name;
	}



 

// המתודה מחזירה את כל המשתמשים
public  void getAllUsers ()throws Exception  {
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs = null;
	String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"; //"jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"
	   	
	    
	    try
	    {
	    	myConn = DriverManager.getConnection(url);
	    	myStmt = myConn.createStatement();
	    	myRs = myStmt.executeQuery("select * from USERS");
	        FileWriter fw = new FileWriter("reportAllUsers.txt"); // לשנות בהתאם למחשב שנציג עליו את הפרוייקט$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	        BufferedWriter bw = new BufferedWriter(fw);
	        String line1 ="";
	        String line2 = "All users report:";
	        String line3= "------------------";
	        String line4="Email\t\t Name\t Phone\t\t Pass\n";
	        bw.write(line2);
	        bw.newLine();
	        bw.write(line3);
	        bw.newLine();
	        bw.write(line4);
	        bw.newLine();
	         		
	        while(myRs.next())
	        {
	        	line1 = myRs.getString(1)+"\t"+myRs.getString(2)+"\t"+myRs.getString(3)+"\t"+myRs.getString(4);
	        	// line = myRs.getInt(1)+"\t"+myRs.getString(2)+"\t"+myRs.getDouble(3);
	            bw.write(line1);
	            bw.newLine();
	        }
	        bw.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	        	myConn.close();
	        	myRs.close();
	        	myStmt.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
	    JOptionPane.showMessageDialog(null, "Report issued successfully!");
	
}

public  void listActivitiesByRating ()throws Exception  {
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs = null;
	String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"; //"jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"
	   	
	    
	    try
	    {
	    	myConn = DriverManager.getConnection(url);
	    	myStmt = myConn.createStatement();
	    	
	    	myRs = myStmt.executeQuery("select name, ActivityID, avg(DISTINCT rating) as AverageRating from RATING join Activity using(ActivityID) group by ActivityID order by AverageRating desc"); 
	        FileWriter fw = new FileWriter("reportActivitesByRating.txt"); // לשנות בהתאם למחשב שנציג עליו את הפרוייקט$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	        BufferedWriter bw = new BufferedWriter(fw);
	        String line ="";
	        String line2 = "Report activity by rating :";
	        String line3= "---------------------------";
	        String line4="Activity Name\t ActivityID\t Average Rating\n";
	        bw.write(line2);
	        bw.newLine();
	        bw.write(line3);
	        bw.newLine();
	        bw.write(line4);
	        bw.newLine();
	        while(myRs.next())
	        {
	        	line = myRs.getString(1)+"  \t\t"+myRs.getInt(2)+" \t\t"+myRs.getDouble(3);
	            bw.write(line);
	            bw.newLine();
	        }
	        bw.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	        	myConn.close();
	        	myRs.close();
	        	myStmt.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
	    JOptionPane.showMessageDialog(null, "Report issued successfully!");
	
}

public  void ReportActByCapcity ()throws Exception  {
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs = null;
	String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"; //"jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"
	   	
	    
	    try
	    {
	    	myConn = DriverManager.getConnection(url);
	    	myStmt = myConn.createStatement();
	    	myRs = myStmt.executeQuery("select name, ActivityID, currentCap, MaxCap from Activity order by currentCap desc");
	    	FileWriter fw = new FileWriter("ReportActByCapcity.txt");  
	        BufferedWriter bw = new BufferedWriter(fw);
	        String line1 ="";
	        String line2 = "Current activity capacity report:";
	        String line3= "------------------";
	        String line4="Activity Name\t ActivityID\t Current Capacity\t Max Capacity\n";
	        bw.write(line2);
	        bw.newLine();
	        bw.write(line3);
	        bw.newLine();
	        bw.write(line4);
	        bw.newLine();
	         		
	        while(myRs.next())
	        {
	        	line1 = myRs.getString(1)+"\t\t"+myRs.getInt(2)+"\t\t"+myRs.getInt(3)+"\t\t"+myRs.getInt(4);
	        	bw.write(line1);
	            bw.newLine();
	        }
	        bw.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	        	myConn.close();
	        	myRs.close();
	        	myStmt.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
   
	    JOptionPane.showMessageDialog(null, "Report issued successfully!");
	    
}


//מציג לך משתמשים לפי חוג
public  int  ReportUserByActiviy (int activityid)throws Exception  {
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs = null;
	String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"; //"jdbc:sqlite:c:\\sqlite3\\db\\myDB.db"
	   	
	    
	    try
	    {
	    	myConn = DriverManager.getConnection(url);
	    	myStmt = myConn.createStatement();
	    	int activityId= activityid;
	    	
	    	PreparedStatement st1=myConn.prepareStatement("select USER_EMAIL from USERinACTIVITY where (ACTIVITY_ID = (?))");
	    	st1.setInt(1,activityId); 
	    	myRs= st1.executeQuery();
	    	//myRs = st1.executeQuery("select USER_EMAIL from USERinACTIVITY where (ACTIVITY_ID = (?))");
	    	
	    	
	    	FileWriter fw = new FileWriter("ReportUserByActiviy.txt");  
	        BufferedWriter bw = new BufferedWriter(fw);
	        String line1 ="";
	        String line2 = "List of registered users by Email:";
	        String line3= "-----------------------------------";
	        String line4="User Email\n";
	        	        
	        bw.write(line2);
	        bw.newLine();
	        bw.write(line3);
	        bw.newLine();
	        bw.write(line4);
	        bw.newLine();
	        
	        if (myRs.next()== false) {
	        	bw.close();
	        	return 0;
	        }
	        	
	                
	        while(myRs.next())
	        {
	        	line1 = myRs.getString(1);
	        	bw.write(line1);
	            bw.newLine();
	        }
	        bw.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	        	myConn.close();
	        	myRs.close();
	        	myStmt.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        
	    }
	    JOptionPane.showMessageDialog(null, "Report issued successfully!");
	    return 1;
	    
}


@Override
public String toString() 
{
	return "" + NAME +"";
}
	


 


	
	
 
}//endClass
 