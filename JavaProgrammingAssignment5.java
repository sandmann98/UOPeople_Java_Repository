import javax.swing.JOptionPane;
public class MultipleChoiceQuestion extends Question {
	MultipleChoiceQuestion(String query, String a, String b, String c,
String d, String e, String answer) {
		question = query+"\n";
		question += "A. "+a+"\n";
		question += "B. "+b+"\n";
		question += "C. "+c+"\n";
		question += "D. "+d+"\n";
		question += "E. "+e+"\n";
		correctAnswer = answer.toUpperCase();
		
 }
	
 String ask() {
	 while (true) {
		 String answer = JOptionPane.showInputDialog(question);
		 answer = answer.toUpperCase();
		 boolean valid = (answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D") || answer.equals("E"));
		 if (valid) return answer;
		 JOptionPane.showMessageDialog(null,"Invalid answer.Please enter A, B, C, D, or E.");
		
	 	}
	 
 	}
 
}


//Quiz

public class Quiz {
	public static void main(String[] args) {
		Question question=new TrueFalseQuestion("Online games is fun!","y");
		question.check();
		question=new TrueFalseQuestion("Figthing is good!","n");
		question.check();
		question=new TrueFalseQuestion("Swimmming is good?","t");
		question.check();
		question=new TrueFalseQuestion(" You like ice cream?","f");
		question.check();
		question=new TrueFalseQuestion("Are you a vampire","true");
		question.check();
		
		
		question=new MultipleChoiceQuestion("Where are you from?", "Mars", "Jupiter", "Pluto", "Venus", "Saturn.", "a");
		question.check();
		question=new MultipleChoiceQuestion("What is your favorite color?", "red", "blue", "pink", "yellow", "orange", "b");
		question.check();
		question=new MultipleChoiceQuestion("Who is your bestfriend?", "laptop", "human", "another galaxy", "wolf", "vamps", "e");
		question.check();
		question=new MultipleChoiceQuestion("What is your favorite drinks?", "water", "juice", "sofdrink", "chocolate", "tea", "d");
		question.check();
		question=new MultipleChoiceQuestion("Do you have many friends?", "few", "many", "zero", "million", "thousand", "a");
		question.check();
		MultipleChoiceQuestion.showResults();
		
		}
	
}
