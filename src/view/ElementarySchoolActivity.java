package view;

public class ElementarySchoolActivity extends EducationActivity {
	
	// attributes
	
	private String certification;
	private String transport; // שירותי הסעות
	private String accessable; // נגישות
	
	
/////////////////////////
	
	// C'tor + get\set
	
	public ElementarySchoolActivity() {
		super();
		this.certification = "non";
		this.transport = "non";
		this.accessable = "non";
		
	}

	public ElementarySchoolActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, int price,
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
		// TODO Auto-generated method stub

	}
	
	public void prerequisites() {
		// TODO Auto-generated method stu
	}
	
	
	
	

}
