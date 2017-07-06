package Cs356.iVoteSimulator;

import java.util.ArrayList;
import java.util.List;

public class SingleChoiceQuestion extends Question {

	public SingleChoiceQuestion(String question, ArrayList<String> choices, ArrayList<String> answers) {
		
		super(question, choices, answers);
		
		if(answers.size() > 1){
			System.out.println("Single choice question type must have one and only one answer.");
		}
	}

}
