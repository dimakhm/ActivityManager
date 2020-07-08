package Testing;

import java.sql.SQLException;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import controller.AdminController;
import controller.UserController;
import model.ActivityRepository;
import model.LogInRepository;
import model.OtherActivity;
import model.User;

class UserTest {

	
	User inValid=new User(" "," "," "," ");
	User userValid=new User("or@gmail.com","123","or","0544378025");
	UserController userController=new UserController();
	LogInRepository logInRepository=new LogInRepository();
	ActivityRepository activityRepository= new ActivityRepository();
	AdminController admincontroller=new AdminController();
	
	
	@Test
	public void UserLogInValid() { 
		
		userValid=userController.signIn(userValid);
		Assert.assertEquals("or@gmail.com",userValid.getEmail());
	}

	@Test
	public void signUpUserTest() {
		
		Boolean bool=true;
		User newUser=new User("test","123","nissim","0544378025");
		 try {
			bool=logInRepository.SignUpUser(newUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 System.out.println(bool);
		 Assert.assertTrue(bool==true);
		}
	
	@Test
	public void signUpUserInvalidTest() {
		
		Boolean bool=true;
		User newUser=new User("non","non","non","non");
		 try {
			bool=logInRepository.SignUpUser(newUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 Assert.assertTrue(bool==false);
		}

	
	@Test
	private void registerToActivirtyTest() {
		Boolean check=true;
		OtherActivity newAct=new OtherActivity(222, "temp", "temp", 5, 5, 500, "temp", "temp", "temp", "temp");
		try {
			activityRepository.addOtherActivity(newAct);
			check=userController.RegisterUserToAvctivity(userValid, 222);
			 Assert.assertTrue(check==false);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	
	}

	
	
	
	
	
	
	
}
