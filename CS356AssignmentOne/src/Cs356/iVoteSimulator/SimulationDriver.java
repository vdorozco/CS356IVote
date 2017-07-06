package Cs356.iVoteSimulator;

import java.util.ArrayList;
import java.util.Random;


public class SimulationDriver {

    public static void main(String[] args){
        // Question 1
        ArrayList<String> q1Choices = new ArrayList<String>();
        q1Choices.add("A");
        q1Choices.add("B");
        q1Choices.add("C");
        q1Choices.add("D");
        ArrayList<String> q1Answers = new ArrayList<String>();
        q1Answers.add("B");
        Question q1 = new SingleChoiceQuestion("\nWhat is 9+10?\n\nA: 21\nB: 19\nC: 0\nD: -3\n", q1Choices, q1Answers);

        ArrayList<Student> students = randGenStudents();
        randGenAnswers(students, q1Choices, q1Answers);
        submitAnswers(students, q1);

        // Question 2
        ArrayList<String> q2Choices = new ArrayList<String>();
        q2Choices.add("A");
        q2Choices.add("B");
        q2Choices.add("C");
        q2Choices.add("D");
        ArrayList<String> q2Answers = new ArrayList<String>();
        q2Answers.add("A");
        q2Answers.add("C");
        Question q2 = new MultipleChoiceQuestion("\nWho is Kylie Jenner? .\n\nA: A model \nB: A singer model C.F.\nC:Insignificant girl.\nD: A thot", q2Choices, q2Answers);

        students = randGenStudents();
        randGenAnswers(students, q2Choices, q2Answers);
        submitAnswers(students, q2);

        // Question 3
        ArrayList<String> q3Choices = new ArrayList<String>();
        q3Choices.add("1. Right");
        q3Choices.add("2. Wrong");
        ArrayList<String> q3Answers = new ArrayList<String>();
        q3Answers.add("1. Right");
        Question q3 = new SingleChoiceQuestion("\nDrake won BET Album of The Year in 2016.\n\n1. Right\n2. Wrong\n", q3Choices, q3Answers);

        students = randGenStudents();
        randGenAnswers(students, q3Choices, q3Answers);
        submitAnswers(students, q3);
    }

    // Randomly generates a student group size ranging from 5-30 and making sure each uniqueID is indeed unique
    private static ArrayList<Student> randGenStudents(){
        ArrayList<Student> students = new ArrayList<Student>();
        Random rand = new Random();
        int numStudents = 5+rand.nextInt(25);
        students.add(new Student(9000000+rand.nextInt(900000)));
        for (int i=0; i<numStudents; i++){
            int uniqueID = 9000000+rand.nextInt(900000);
            students.add(new Student(uniqueID));
        }
        return students;
    }

    // Randomly generates student answers and handles single and multiple answers
    // it also makes sure that multiple answers are not duplicates
    private static void randGenAnswers(ArrayList<Student> students, ArrayList<String> choices, ArrayList<String> answers){
        Random rand = new Random();
        int numAnswers = 1;
        for (int i=0; i<students.size(); i++) {
            if(answers.size()>1){
                numAnswers = rand.nextInt(choices.size()-1)+1;
                for (int j=0; j<numAnswers; j++) {
                    int multAnswer = rand.nextInt(choices.size());
                    if (!students.get(i).getAnswer().contains(choices.get(multAnswer)))
                        students.get(i).setAnswer(choices.get(multAnswer));
                }
            }
            else
                for (int j = 0; j < numAnswers; j++) {
                    students.get(i).setAnswer(choices.get(rand.nextInt(choices.size())));
                }
        }
    }

    // Submits student group answers
    private static void submitAnswers(ArrayList<Student> students, Question question){
        iVoteService iVote = new iVoteService(question);
        iVote.submit(students);
        iVote.outputStats();
    }
}
