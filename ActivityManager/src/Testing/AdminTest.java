package Testing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import controller.AdminController;
//import controller.UserController;
import model.Admin;

public class AdminTest {

	//attributes
	
	Admin adminInValid=new Admin("non","non");
	Admin adminValid=new Admin("admin@admin.com", "admin");
	AdminController adminController=new AdminController() ;

	
	@Test
	public void UserLogInValid() { 
		
		adminValid=adminController.signIn(adminValid);
		Assert.assertEquals("admin@admin.com",adminValid.getEmail());
	}

//	@Test
//	public void UserLogInInValid() {
//		
//		adminInValid=adminController.signIn(adminInValid);
//		Assert.assertEquals("non", adminInValid.getEmail());
//		
//	}
	
	
//	@Test
//	public void UserLogInValid() { 
//		
//		adminValid=adminController.signIn(adminValid);
//		Assert.assertEquals("admin@admin.com",adminValid.getEmail());
//	}
//	
	
	
	
}
