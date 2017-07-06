package Cs356.iVoteSimulator;

import java.util.ArrayList;

public class Student {
	
	private String uniqueID;
	private ArrayList<String> answer = new ArrayList<String>();
	
	public Student (int idNumber){
		this.uniqueID = Integer.toString(idNumber);
	}
	
	public String getUniqueId(){
		return uniqueID;
	}
	
	public ArrayList<String> getAnswer(){
		return answer;
	}
	
	public void setAnswer(String choice){
		answer.add(choice);
	}

}
