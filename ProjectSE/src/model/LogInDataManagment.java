package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import controller.User;

public class LogInDataManagment {

	
	
	public static User userlogIn(String Email, String Pass) throws Exception // return true if login successfully
	{
		Connection conn=null;
    	User old=new User();

		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	             
		            PreparedStatement st=conn.prepareStatement("select *from USERS where EMAIL=? and PASS=?");
		            st.setString(1, Email);
		            st.setString(2, Pass);
		            
		            ResultSet answer = st.executeQuery();
		        

		            int counter=0;
		            while(answer.next())
	             {
		            
		           counter++;
		           if(counter==1)
		           	{
	            	old.setEmail(Email);
	            	old.setPass(Pass);
	            	String name =answer.getString("NAME");
	            	String phone =answer.getString("PHONE");
	            	old.setName(name);
	            	old.setPhone(phone);
	            	JOptionPane.showMessageDialog(null, "LogIn SECCESS");
		              st.close();
			          answer.close();
			          return old;	
		            }
		          
	             }  
		           
		            JOptionPane.showMessageDialog(null, "LogIn fail, Try again or Sign up");
		                st.close();
			            answer.close();
		                return old; 
		            
		            
		            
			}//end try

		finally {
			conn.close();
		}
		
		
		
		
		
	}//func end
	
	
	public static boolean adminlogIn(String Email, String Pass) throws Exception // return true if login successfully
	{
		Connection conn=null;
		
		try {
			 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
	             conn = DriverManager.getConnection(url);
	             
		            PreparedStatement st=conn.prepareStatement("select *from ADMIN where EMAIL=? and PASS=?");
		            st.setString(1, Email);
		            st.setString(2, Pass);
		            
		            ResultSet answer = st.executeQuery();
		            int counter=0;
		            while(answer.next())
	             {
		            	counter++;
		            	
	             }
		            if(counter==1)
		            {
		            	JOptionPane.showMessageDialog(null, "LogIn SECCESS");
		                st.close();
			             answer.close();
		                return true;
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "LogIn fail, Try again");
		                st.close();
			            answer.close();
		                return false;
		            }
	               

	             
			}//end try

		finally {
			conn.close();
		}
		
	}//func end
	
	public static void SingUpUserToDataBase(User inputUser) throws Exception
	{
	Connection conn=null;
	
	try {
		 String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
             conn = DriverManager.getConnection(url);
	           
	            
	            PreparedStatement st=conn.prepareStatement("INSERT INTO USERS (EMAIL,PASS,NAME,PHONE) VALUES (?,?,?,?)");
	            st.setString(1, inputUser.getEmail());
	            st.setString(2, inputUser.getPassword());
				st.setString(3, inputUser.getName());
	            st.setString(4, inputUser.getPhone());
	            st.executeUpdate();
	           
	           
			}//end try

		finally {
			conn.close();
		}
	
	
}
	
	
}
