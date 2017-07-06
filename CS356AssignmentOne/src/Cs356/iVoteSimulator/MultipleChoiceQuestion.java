package Cs356.iVoteSimulator;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

	public MultipleChoiceQuestion(String question, ArrayList<String> choices, ArrayList<String> answers){
		
		super(question, choices, answers);
		
		if(answers.size() < 1){
			System.out.println("Multi choice question type musth ave at least one answer");
		}
	}
}

