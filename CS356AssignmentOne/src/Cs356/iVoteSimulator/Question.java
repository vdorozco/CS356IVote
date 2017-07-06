package Cs356.iVoteSimulator;

import java.util.ArrayList;
import java.util.List;

public abstract class Question{
	
	private String question;
	
	private ArrayList<String> choices;
	private ArrayList<String> answers;
	
	public Question(String question, ArrayList<String> choices, ArrayList<String> answers){
		
		this.question = question;
		this.choices = choices;
		this.answers = answers;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public List<String> getChoices(){
		return choices;
	}
	
	public List<String> getAnswers(){
		return answers;
	}
}
