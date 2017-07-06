package Cs356.iVoteSimulator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class iVoteService {
	
	private Hashtable<String, ArrayList<String>> submissions = new Hashtable<String, ArrayList<String>>();
	private Question question;
	private int correct, a, b, c, d;
	private int wrong;
	
	public iVoteService(Question question){
		
		this.question = question;
		this.submissions = new Hashtable<String, ArrayList<String>>();
		this.correct = 0;
	}
	
	public void submit(ArrayList<Student> students){
		
		for(int i = 0; i < students.size(); i++){
			
			ArrayList  <String> valid = new ArrayList<String>();
			
			for(int j = 0; j < students.get(i).getAnswer().size(); j++){
				
				if(question.getChoices().contains(students.get(i).getAnswer().get(j))){
					
					valid.add(students.get(i).getAnswer().get(j));
				}
			}
			submissions.put(students.get(i).getUniqueId(), (ArrayList<String>) valid);
		}
	}
			
	public void outputStats(){
		
		int counter = 0;
		
		for(Map.Entry<String, ArrayList<String>> entry : submissions.entrySet()){
			
			if(question.getAnswers().containsAll(entry.getValue())){
				correct++;
			}
			
			if(entry.getKey().contains(question.getChoices().get(0))){
				a++;
			}
			
			if(entry.getValue().contains(question.getChoices().get(1))){
				b++;
			}
			
			if(question.getChoices().size() > 2){
				if(entry.getValue().contains(question.getChoices().get(2))){
					c++;
				}
				
				if(entry.getValue().contains(question.getChoices().get(3))){
					d++;
				}
			}
			
			counter++;
			
		}
		

        System.out.println(question.getQuestion());
        System.out.println("Total Submissions:\n"+counter);
        System.out.println("Submissions:");
        if(question.getChoices().size()>2){
            System.out.println("A: "+a+"\nB: "+b+"\nC: "+c+"\nD: "+d);
        }else
        System.out.println("1. Right: "+a+"\n2. Wrong: "+b);
        System.out.println("Correct Answers "+correct);
        System.out.println("Incorrect Answers "+(counter-correct));
		
	}	
	
}


