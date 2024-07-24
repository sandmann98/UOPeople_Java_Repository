package RandomPhrases;

public class RandomeSentencesUnit2 {
    /*
    <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]

<simple_sentence> ::= <noun_phrase> <verb_phrase>

<noun_phrase> ::= <proper_noun> |<determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]

<verb_phrase> ::= <intransitive_verb> |<transitive_verb> <noun_phrase> |is <adjective> |believes that <simple_sentence>

    */


/*Generated string arrays with the given data*/
static final String[] proper_noun = { "Fred", "Jane", "Richard Nixon", "Miss America" };
static final String[] common_noun = { "man", "woman", "fish", "elephant","unicorn" };                                  
   static final String[] intransitive_verb = { "runs", "jumps", "talks",
                                   "sleeps"};
   static final String[] transitive_verb = { "loves", "hates", "sees",
                                   "knows","looks for","finds"};
   static final String[] conjunction = { "and", "or", "but","because"}; 
  static final String[] determiner = { "a", "the", "every","some"}; 
static final String[] adjective = { "big", "tiny", "pretty","bald"}; 

/*Main method executes the random sentence method in a while loop*/

    public static void main(String[] args) {
        	while (true) {
			randomSentence();
			System.out.println("\n\n");
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e) {
			}
		}
    }
    /**
	 * Generates a random sentence, following the grammar rule for a sentence.
	 */
    static void randomSentence(){
                if (Math.random() > 0.2) 
            randomsimpleSentence();
               
        if (Math.random() > 0.75){
            System.out.print(" " + randomItem(conjunction));
            randomSentence();
        }
    }
    /**
	 * Generates a random simple sentence, following the grammar rule for a simple sentence.
	 */
    static void randomsimpleSentence() {
        if (Math.random() > 0.2) 
            randomNounPhrase();
                randomVerbPhrase();
        if (Math.random() > 0.75){
            System.out.print(" " + randomItem(conjunction));
            randomsimpleSentence();
        }
    }
    /**
	 * Generates a random noun_phrase, following the grammar rule for a noun_phrase.
	 */
        static void randomNounPhrase() {
        if (Math.random()> 0.75)
            System.out.print(" "+ randomItem(proper_noun));
        else
        {
            System.out.print(" "+ randomItem(determiner));
            if (Math.random()> 0.5)
        System.out.print(" "+ randomItem(adjective)+".");
            System.out.print(" "+ randomItem(common_noun));
            if (Math.random() > 0.5){
                System.out.print(" who ");
                randomVerbPhrase();
            }
        }
    }
        /**
	 * Generates a random Verb phrase, following the grammar rule for a noun_phrase.
	 */
        static void randomVerbPhrase() {

        if (Math.random() > 0.75)// 25% chance of having a modifier.
            System.out.print(" "+ randomItem(intransitive_verb));
        else if (Math.random() > 0.50){// 50% chance of having another noun phrase.
            System.out.print(" " + randomItem(transitive_verb));
            randomNounPhrase();
        }
        else if (Math.random() > 0.25)
            System.out.print(" is " + randomItem(adjective));
        else{
            System.out.print(" believes that ");
            randomNounPhrase();
            randomVerbPhrase();
        }
    }
    static String randomItem(String[] listOfStrings){
         return listOfStrings[(int)(Math.random()*listOfStrings.length)];
    }