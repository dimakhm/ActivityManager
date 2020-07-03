package model;

import javax.swing.JOptionPane;

public class ElementarySchoolActivity extends EducationActivity {
	
	// attributes
	
	private String certification;
	private String transport; // ������ �����
	private String accessable; // ������
	
	
/////////////////////////
	
	// C'tor + get\set
	
	public ElementarySchoolActivity() {
		super();
		this.certification = "non";
		this.transport = "non";
		this.accessable = "non";
		
	}

	public ElementarySchoolActivity(int id) {
		super();
		this.activityID=id;
		this.certification = "non";
		this.transport = "non";
		this.accessable = "non";
		
	}
	
	public ElementarySchoolActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, Double price,
			String description, String teacher,String porfession,String remoteClass,String certification , String transport,String accessable ) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description,teacher ,porfession, remoteClass);
		this.certification=certification;
		this.transport=transport;
		this.accessable=accessable;
	}
	
	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getAccessable() {
		return accessable;
	}

	public void setAccessable(String accessable) {
		this.accessable = accessable;
	}
	
	
//////////////////////	
	
	
	// methods
	
	public void showActivityInfo() {
		System.out.println("Name: "+this.name);

	}
	
	public void prerequisites() {
		JOptionPane.showMessageDialog(null, "The student must be belongs to one of the elementary school in the city ");

	}
	
	
	
	

}
