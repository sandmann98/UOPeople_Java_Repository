import java.awt.event.*;
import javax.swing.*;

public class QuestionDialog extends JDialog implements ActionListener{
	
	String answer;
	@Override
	public void actionPerformed(ActionEvent e) {
		answer = e.getActionCommand();
		dispose();
	}
	
}


Question.java


import javax.swing.*;
import java.awt.*;

public abstract class Question {

    static int nQuestions = 0;
    static int nCorrect = 0;
    QuestionDialog question;
    String correctAnswer;

    public Question(String question) {
        this.question = new QuestionDialog();
        this.question.setLayout(new GridLayout(0,1));
        this.question.add(new JLabel(" "+question+" ", JLabel.CENTER));
    }
  
    String ask() {
        question.setVisible(true);
        return question.answer;
    }

    void check() {
        nQuestions++;
        String answer = ask();
        if (answer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(null, "Correct!");
            nCorrect++;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctAnswer + ".");
        }
    }

    static void showResults() {
        JOptionPane.showMessageDialog(null, nCorrect + " correct out of " + nQuestions + " questions");
    }
  
    void initQuestionDialog(){
        this.question.setModal(true);
        this.question.pack();
        this.question.setLocationRelativeTo(null);
    }
}


TrueFalseQuestion.java


import javax.swing.*;

public class TrueFalseQuestion extends Question {

  

    TrueFalseQuestion(String question, String answer) {
    		super(question);
        JPanel buttons = new JPanel();
        addButton(buttons, "TRUE");
        addButton(buttons, "FALSE");
        this.question.add(buttons);
        initQuestionDialog();
        answer = answer.toUpperCase();
        if (answer.equals("T") || answer.equals("TRUE") || answer.equals("Y") || answer.equals("YES")) {
            correctAnswer = "TRUE";
        }
        if (answer.equals("F") || answer.equals("FALSE") || answer.equals("N") || answer.equals("NO")) {
            correctAnswer = "FALSE";
        }
    }
  
    void addButton(JPanel buttons, String label){
        JButton button = new JButton(label);
        button.addActionListener(question);
        buttons.add(button);
    }
}

MultipleChoiceQuestion.java
import javax.swing.*;
import java.awt.*;

public class MultipleChoiceQuestion extends Question {  
	
	MultipleChoiceQuestion(String query, String a, String b, String c, String d, String e, String answer) {
		super(query);
		addChoice("A", a);
		addChoice("B", b);
		addChoice("C", c);
		addChoice("D", d);
		addChoice("E", e);
		initQuestionDialog();
		correctAnswer = answer.toUpperCase();
	}
	
	void addChoice(String name, String label){
		JPanel choice = new JPanel(new BorderLayout());
		JButton button = new JButton(name);
		button.addActionListener(question);
		choice.add(button, BorderLayout.WEST);
		choice.add(new Label(label+" ",JLabel.LEFT), BorderLayout.CENTER);
		question.add(choice);
	}
	}
		
