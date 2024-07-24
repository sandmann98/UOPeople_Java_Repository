import javax.swing.JOptionPane;
public class Quiz {
  static int nQuestions = 0;
  static int nCorrect = 0;
  static String ask(String question) 
  {while (true) {
    String answer = JOptionPane.showInputDialog(question);
    answer = answer.toUpperCase();
    boolean valid = (answer.equals("A") ||  answer.equals("B") 
    ||answer.equals("C") || answer.equals("D") || 
    answer.equals("E"));
    if (valid) return answer;    
     JOptionPane.showMessageDialog(null,"Invalid answer. Please enter A, B, C, D, or E.");
     }
     }
      static void check(String question, String correctanswer) {   
        nQuestions++; String answer = ask(question); 
        if (answer.equals(correctanswer)) { 
          JOptionPane.showMessageDialog(null,"correct!");
           nCorrect++; 
           }  else { 
            JOptionPane.showMessageDialog(null,"Incorrect. The correct answer is " +  
            correctanswer + ".");
             }
            } 
            public static void main(String[] args) { 
              String question = "What is your favourite place in Dubai?\n";
              question += "A. Dubai Aquarium in Dubai Mall.\n"; 
              question += "B. Ski Dubai in Mall of Emirates.\n";
              question += "C. Zero Gravity club.\n";
              question += "D. Waldorf Astoria Beach.\n";
              question += "E. Global Village.";
              check(question,"A");
              question = "What is your favorite food?\n";
              question += "A. Pizza.\n";
              question += "B. Pasta.\n";
              question += "C. Seafood.\n"; 
              question += "D. California Maki.\n";
              question += "E. Japanese Bento.";
              check(question,"C")
              question = "What is your favorite manga?\n";
              question += "A. Naruto.\n";
              question += "B. Hunter X Hunter.\n";
              question += "C. Boruto.\n";
              question += "D. Vampire.\n";
              question += "E. Dragon Ball Z.";
              check(question,"D");
  JOptionPane.showMessageDialog(null,nCorrect+" correct out of "+nQuestions+" questions");
   }
   }
