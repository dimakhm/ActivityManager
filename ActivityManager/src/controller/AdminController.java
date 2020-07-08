package controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Activity;
import model.ActivityFactory;
import model.ActivityRepository;
import model.Admin;
import model.ElementarySchoolActivity;
import model.HighSchoolActivity;
import model.LogInRepository;
import model.OtherActivity;
import model.RatingAndReviewRepository;
import model.ReportRepository;
import model.User;


public class AdminController
{
	
	//attributes
	RatingAndReviewRepository ratingAndReviewRepository;
	LogInRepository logInRepository;
	ActivityRepository activityRepository;
	ActivityFactory activityFactory;
	ReportRepository reportRepository;
	
	//c'tor
	public AdminController()
	{
		this.ratingAndReviewRepository=new RatingAndReviewRepository();
		this.activityRepository=new ActivityRepository();
		this.logInRepository=new LogInRepository();
		this.activityFactory=new ActivityFactory();
		this.reportRepository=new ReportRepository();
	}

	//methods
	
	public Admin signIn(Admin admin) {  // gets admin input, if exist-> return the right admin and all his info, else-> return empty admin object
		
		try {
			admin=logInRepository.adminlogIn(admin.getEmail(),admin.getPassword());
		} catch ( SQLException e) {

			e.printStackTrace();
		}
		
		
		return admin;
		
	}

	public void deleteActiviry(int activityID) {
		
		try {
			activityRepository.deleteActivity(activityID);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
	}

	public void deleteUserFromActivity(String email, int activityID) {

		try {
			activityRepository.deleteUserFromActivity(email, activityID);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
	
	public void deleteReview(int SerialNumber ) {

		try {
			ratingAndReviewRepository.deleteReview(SerialNumber);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
	
	public List<User> getAllUser() throws Exception {
		List<User> list = new ArrayList<>();
		
			list=activityRepository.getAllUsers();
			return list;
	
		
		
	}
	
	public Activity getAvtivity(String ActivityType){
	
		   return activityFactory.getAvtivity(ActivityType);
	
		   
	   }
		
	public void addElemetarySchoolActivity(ElementarySchoolActivity activity) {

		   try {
			activityRepository.addElamentryShcoolActivity(activity);
		} catch (Exception e) {

			e.printStackTrace();
		}
	   }   
		   
	public void addHighSchoolActivity(HighSchoolActivity activity) {

			   try {
				activityRepository.addHighShcoolActivity(activity);
			} catch (Exception e) {

				e.printStackTrace();
			}
		   
	}
	      
    public void addOtherActivity(OtherActivity activity) {

			   try {
				activityRepository.addOtherActivity(activity);
			} catch (Exception e) {

				e.printStackTrace();
			}
		   
	}
		   
	public List<OtherActivity> getActivityByHighRating() throws Exception {
		List<OtherActivity> list ;
		list=reportRepository.getActivityByHighRating();
		return list;
	}  
	   
    
	public List<User> getUsersInSpecificActivity(int activityId) throws Exception {
		List<User> list = new ArrayList<>();
		list=reportRepository.getUsersInSpecificActivity(activityId);
		return list;
	}  
	   
    
	}// class end
	
	



	

