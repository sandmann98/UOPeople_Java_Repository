import javax.swing.JOptionPane;
public	class MultipleChoiceQuestion{			
		static	int	nQuestions=0; 
		//The variable is to count the number of questions.
		static	int	nCorrect=0; 
		//The variable is to count the number of correct answers.
		String	question;
		String	correctAnswer;
		MultipleChoiceQuestion(String query,String a,String	b,String c,String d,String e,String answer){
				question=query+"\n";
				question+="A."+a+"\n";
				question+="B."+b+"\n";
				question+="C."+c+"\n";
				question+="D."+d+"\n";
				question+="E."+e+"\n";
				correctAnswer=answer;
				correctAnswer=correctAnswer.toUpperCase();
		}
	
		/*
		 * Here is the method that takes a question as parameter and returns the answer in the question.
		 * User must input a valid answer without which the input dialog keeps popping up*/				
String ask(){
		while(true){
			  String answer=JOptionPane.showInputDialog(question);
		      answer=answer.toUpperCase();
		      boolean	valid=(answer.equals("A")||answer.equals("B")||answer.equals("C")||answer.equals("D")||answer.equals("E"));
		      if(valid)return	answer;
		      JOptionPane.showMessageDialog(null,"Invalid	answer.Please enter A,B,C,D,orE.");
					}
	}

/*
 * The method verifies if the valid answer that was provided by user
 * is the correct answer.
 * It does so by calling the ask() method and counting the number of times it called method.
 * If the answer is valid and correct, it prints out the message correct and 
 * counts the number of correct answers.
 * If the valid input is the wrong answer, it prints out the correct answer*/
void check(){
		nQuestions++;
		String answer=ask();
		if(answer.equals(correctAnswer)){	
				JOptionPane.showMessageDialog(null,"Correct!");
				nCorrect++;
			}else{
				JOptionPane.showMessageDialog(null,"Incorrect.The correct answer "
						+ "is"+correctAnswer+".");
			}
	}
		
void showResults(){
				JOptionPane.showMessageDialog(null,nCorrect+"correct out of "+nQuestions+"questions ");
		}
	}


public	class	Quiz{
	public	static void main(String[]args){
			MultipleChoiceQuestion	question1=new	
MultipleChoiceQuestion("What your favourite movie?", "twiligh saga", "nothing", "i never watch movie", "drama", "boring.", "a");
			question1.check();
			question1.showResults();
			MultipleChoiceQuestion question2=new	
MultipleChoiceQuestion("What you going to do when you go back home?", "doing nothing", "study", "have fun with friends", "going to club", "sleeping","b");
			question2.check();
			question2.showResults();
			MultipleChoiceQuestion question3=new	
MultipleChoiceQuestion("When you go back home?", "november ", "december ", "august ", "september", "nothing", "c");
			question3.check();
			question3.showResults();
			MultipleChoiceQuestion question4=new
MultipleChoiceQuestion("What kind of field are you going to focus on related to computer science?", "doing nothing", "programmer", "game developer", "ethical hacking", "web developer","e");
			question4.check();
			question4.showResults();
			MultipleChoiceQuestion question5=new	
MultipleChoiceQuestion("Who is your trusted friend in this world.?", "outside the uopeople ", "your workplace", "new friend anywhere ", "only uopeople", "nothing", "d");
			question5.check();
			question5.showResults();			
			
		}
}

