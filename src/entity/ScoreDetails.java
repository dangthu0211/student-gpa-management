package entity;

import java.io.Serializable;

public class ScoreDetails implements Serializable{
	private Subject subject;
	private int score;

	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
        return "ScoreDetail{" +
                "Subject=" + subject +
                ", Score=" + score +
                '}';
    }
}
