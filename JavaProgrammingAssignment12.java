import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JFileChooser;

/**
 * This is the class works as a spell-checker. It uses the file words.txt to
 * check whether a given word is correctly spelled of it.
 */
public class SpellChecker {

    public static void main(String[] args) {
    	
        Scanner filein;
        HashSet<String> dict = new HashSet<String>();
        Scanner in;
        
        try {
        
            filein = new Scanner(new File("C:\\\\Users\\\\user\\\\Documents\\\\Code Unit 5-20191217\\\\dictionary"));
        
            while (filein.hasNext()) {
                String word = filein.next();
                dict.add(word.toLowerCase());
            }
            
            System.out.println("Size of HashSet : " + dict.size());
            
            in = new Scanner(getInputFileNameFromUser());
            
            // It skip over the any non-letter characters in the file of it.
            
            in.useDelimiter("[^a-zA-Z]+");
                
            HashSet<String> badWords = new HashSet<String>();
            while (in.hasNext()) {
                String userWord = in.next();
                userWord = userWord.toLowerCase();
                if (!dict.contains(userWord) && 
                    !badWords.contains(userWord)) {
                    
                    badWords.add(userWord);
                    TreeSet<String> goodWords = new TreeSet<String>();
                    goodWords = corrections(userWord, dict);
                    System.out.print(userWord + ": ");
                    if (goodWords.isEmpty())
                        System.out.println("(no suggestions)");
                    else {
                        int count = 0;
                        for (String goodWord: goodWords) {
                            System.out.print(goodWord);
                            if (count < goodWords.size() - 1)
                                System.out.print(", ");
                            else
                                System.out.print("\n");
                            count++;
                        }
                    }
                    
                }
            
            }
            
        }
        catch (FileNotFoundException e) {
            System.exit(0);
        }
    
    }	 // the end main()
    
    /**
     * Lets the user select an input file using a standard file selection
     * dialog box. If the user cancels the dialog without selecting a file,
     * the return value is null.
     *
     * @return A file selected by the user, if any. Otherwise, null.
     */
    static File getInputFileNameFromUser() {
    
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();
    
    } // the end getInputFileNameFromUser()
    
    /*
     * It gives a list of possible correct spellings for misspelled words which
     * are variations of a a given word that are present in the dictionary.
     *
     * @return A tree set containing a list of possible corrections to the
     *         misspelled word.
     */
    static TreeSet<String> corrections(String badWord, HashSet<String> dictionary) {
    
        TreeSet<String> possibleWords =  new TreeSet<String>();
        String subStr1, subStr2, possibility;
        
        for (int i = 0; i < badWord.length(); i++) {
        
            // It remove character i from the word.
            subStr1 = badWord.substring(0, i);
            subStr2 = badWord.substring(i + 1);
            
            // It delete any one of the letters from the misspelled word.
            possibility = subStr1 + subStr2;
            if (dictionary.contains(possibility))
                possibleWords.add(possibility);
            
            // It change any letter in the misspelled word into any other
            // letter of it.   
            for (char ch = 'a'; ch <= 'z'; ch++) {
                possibility = subStr1 + ch + subStr2;
                if (dictionary.contains(possibility))
                    possibleWords.add(possibility);
            }

            // The divide the word into two substrings of it.
            subStr1 = badWord.substring(0, i);
            subStr2 = badWord.substring(i);
            
            // Insert any letter at any point in the misspelled word.
            for (char ch = 'a'; ch <= 'z'; ch++) {
                possibility = subStr1 + ch + subStr2;
                if (dictionary.contains(possibility))
                    possibleWords.add(possibility);
            }
            
            // Insert a space at any point in the misspelled word and check
            // that both of the words that are produced are in the dictionary.
            char ch = ' ';
            possibility = subStr1 + ch + subStr2;
            if (dictionary.contains(subStr1) && dictionary.contains(subStr2))
                      possibleWords.add(possibility);
                      
        }
        
        // It swap any two neighboring characters in the misspelled word.
        
        for (int i = 1; i < badWord.length(); i++) {
            subStr1 = badWord.substring(0, i - 1);
            char ch1 = badWord.charAt(i - 1);
            char ch2 = badWord.charAt(i);
            subStr2 = badWord.substring(i + 1);
            possibility = subStr1 + ch2 + ch1 + subStr2;
            if (dictionary.contains(possibility))
                possibleWords.add(possibility);
        }
        
        return possibleWords;
    
    } // the end corrections()

} // the end class SpellChecker