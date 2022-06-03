package entity;

import java.io.Serializable;

public class Scores implements Serializable{

	private Student student;
	private ScoreDetails[] scoreDetails;
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public ScoreDetails[] getScoreDetails() {
		return scoreDetails;
	}
	
	public void setScoreDetails(ScoreDetails[] scoreDetails) {
		this.scoreDetails = scoreDetails;
	}
	
	
}
