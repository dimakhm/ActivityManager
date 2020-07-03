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
import model.User;


public class AdminController
{
	RatingAndReviewRepository ratingAndReviewRepository;
	LogInRepository logInRepository;
	ActivityRepository activityRepository;
	ActivityFactory activityFactory;

	public AdminController()
	{
		this.ratingAndReviewRepository=new RatingAndReviewRepository();
		this.activityRepository=new ActivityRepository();
		this.logInRepository=new LogInRepository();
		this.activityFactory=new ActivityFactory();
	}

	public Admin signIn(Admin admin) {
		
		try {
			admin=logInRepository.adminlogIn(admin.getEmail(),admin.getPassword());
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return admin;
		
	}

	public void deleteActiviry(int activityID) {
		
		try {
			activityRepository.deleteActivity(activityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	public void deleteUserFromActivity(String email, int activityID) {

		try {
			activityRepository.deleteUserFromActivity(email, activityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void deleteReview(int SerialNumber ) {

		try {
			ratingAndReviewRepository.deleteReview(SerialNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }   
		   
		   public void addHighSchoolActivity(HighSchoolActivity activity) {

			   try {
				activityRepository.addHighShcoolActivity(activity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}
	   
		   
		   public void addOtherActivity(OtherActivity activity) {

			   try {
				activityRepository.addOtherActivity(activity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}
		   
	   
	   
	}// class end
	
	



	

