public class TheQuadratic {
   public static void main(String[] args) {
     
      double A, B, C;   
      // The numerical on equation.
      double answer;  
      // The answer computed in the equation.
      boolean goAgain; 
      // It set to the true if the user wants to solve another equation.
                       
      TextIO.putln("The program will print the answer of an equation");
      TextIO.putln("Form A*X*X + B*X + C = 0, where A, B, and");
      TextIO.putln("C are values you enter.");
     
      do {
        
        
    	    	  
         TextIO.putln(); // Take the numerical from the user. 
         TextIO.putln("Enter values for A, B, and C:");
         TextIO.put("A = ");
         A = TextIO.getlnDouble();
         TextIO.put("B = ");
         B = TextIO.getlnDouble();
         TextIO.put("C = ");
         C = TextIO.getlnDouble();
         TextIO.putln();
        
         /* It will print the answer, either error message, if there is no answer. */
           
         try {
            answer = root(A,B,C);
            TextIO.putln("The answer of the equation is " + answer); 
         }
         catch (IllegalArgumentException e) {
            TextIO.putln("I do apologized, no answer.");
            TextIO.putln(e.getMessage());
         }
         
      
         TextIO.putln(); // Look for the another option.
         TextIO.put("You want to try again to solve another equation? ");
         goAgain = TextIO.getlnBoolean();
      } while (goAgain);
  
   } // end main
  
 
   /**
    * It returns to the larger of the two roots of the quadratic equation
    * the A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
    * if the discriminant, B*B - 4*A*C, is negative, then an exception
    * of type IllegalArgumentException is thrown.
    */
   static public double root( double A, double B, double C )
                                 throws IllegalArgumentException {
       if (A == 0) {
         throw new IllegalArgumentException("A can't be zero.");
       }
       else {
          double disc = B*B - 4*A*C;
          if (disc < 0)
             throw new IllegalArgumentException("Discriminant < zero.");
          return  (-B + Math.sqrt(disc)) / (2*A);
          
       }// end class
       
   }  
   
}  


