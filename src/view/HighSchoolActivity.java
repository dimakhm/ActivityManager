package view;

public class HighSchoolActivity extends EducationActivity {

	
	// attributes
	private int studyUnits;
	private String finalExam;
	private String schoolAssociation;
	
	// C'tor + get\set
	public HighSchoolActivity() {
		super();
		this.studyUnits =0;
		this.finalExam = "non";
		this.schoolAssociation = "non";
		
	}
	
	public int getStudyUnits() {
		return studyUnits;
	}

	public void setStudyUnits(int studyUnits) {
		this.studyUnits = studyUnits;
	}

	public String getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(String finalExam) {
		this.finalExam = finalExam;
	}

	public String getSchoolAssociation() {
		return schoolAssociation;
	}

	public void setSchoolAssociation(String schoolAssociation) {
		this.schoolAssociation = schoolAssociation;
	}

	public HighSchoolActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, int price,
			String description, String teacher,String porfession,String remoteClass,int studyUnits , String finalExam,String schoolAssociation) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description,teacher ,porfession, remoteClass);
		this.studyUnits=studyUnits;
		this.finalExam=finalExam;
		this.schoolAssociation=schoolAssociation;
	}
	
	
	
	// methods
	public void showActivityInfo() {
		// TODO Auto-generated method stub

	}
	
	public void prerequisites() {
		// TODO Auto-generated method stub

	}
	
	
	
}
