import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This is a simple game of hangman where you attempt to guess the word with the number of characters given. 
 * If your guess of a character is incorrect, then you will make progress towards losing and the guillotine will slowly fall.
 * 
 * @author Evan Brown 
 * @version 1.0
 */
public class Hangman
{
    private String word;//the word one is trying to guess
    private int numGuesses = 0;//the number of incorrect guesses one has made
    private String guessedLetters;//the letters one has guessed correctly
    private String guess;//one's guess that is inputted into the JOption pane
    private int l;//the length of the word one is guessing
    private int gl;//the length of the word made up of guesses
    private String unusedLetters;//a list of the letters one has already guessed
    private String alphabet;//the letters of the alphabet
    private String usedLetters = "";//the letters one has already guessed
    private int gold = 0;//gold a player has
    private String hint = "";//hint which is specific for each word
    private int hintCount = 0;//number of time used the hints
    private final int MAX_GUESSES = 12;//max number of guesses

    /**
     * Constructor for objects of class Hangman
     */
    public Hangman()
    {

    }

    /**~
     * Sets up the game and allows one to play it until you win or lose.
     */
    public void playGame()
    {
        setUp();
        System.out.println(guessedLetters);
        while(numGuesses < MAX_GUESSES)
        {
            if(guessedLetters.equals(word))
            {
                System.out.println("You Win!");
                System.out.println("The word was '" + word + "'.");
                numGuesses = 0;
                gold = 0;
                break;
            }
            else
            {
                guess();
                if(gold >= word.length()/2)
                {
                    if(hintCount != 1)
                    {
                        System.out.println("You have enough gold to purchase a hint. Would you like to do so?");
                        String store = JOptionPane.showInputDialog(null,"<1> Purchase <2> Don't purchase");
                        if(store.equals("1"))
                        {
                            gold = gold - word.length()/2;
                            System.out.println("You now have " + gold + " gold.");
                            System.out.println("Hint: " + hint);
                            hintCount += 1;
                        }
                        else if(store.equals("2"))
                        {
                            System.out.println("You didn't purchase the hint.");
                        }
                        else
                        {
                            JOptionPane.showInputDialog(null,"<1> Purchase hint <2> Don't purchase");
                        }
                    }
                }
            }
        }
        if(numGuesses >= MAX_GUESSES)
        {
            System.out.println(word);
            System.out.println("You Lose!");
            System.out.println("The word was '" + word + "'.");
            numGuesses = 0;
            gold = 0;
        }
    }

    /**
     * Allows one to guess and then checks if that guess is correct.
     */
    private void guess()
    {
        guess = JOptionPane.showInputDialog(null,"Input guess: ");
        guess = guess.toLowerCase();
        if(guess != null && guess.length() == 1 && alphabet.indexOf(guess) > -1)
        {
            if(usedLetters.indexOf(guess) == -1)
            {
                if(word.indexOf(guess) > -1)
                {
                    display();
                }
                else
                {
                    if(word.length() >= MAX_GUESSES)
                    {
                        numGuesses += 1;
                    }
                    else if(word.length() < MAX_GUESSES)
                    {
                        numGuesses += 2;
                    }
                    makePicture();
                    System.out.println("I'm sorry but '" + guess + "' was not in the word.");
                    if(gold > 0)
                    {
                        gold -= 1;
                        System.out.println("You lost 1 gold.");
                        System.out.println("You now have " + gold + " gold.");
                    }
                    unusedLetters();
                    System.out.println(guessedLetters);
                    System.out.println(unusedLetters);
                    if(word.length() >= MAX_GUESSES)
                    {
                        System.out.println("Incorrect Guesses Remaining: " + (MAX_GUESSES - numGuesses));
                    }
                    else if(word.length() < MAX_GUESSES)
                    {
                        System.out.println("Incorrect Guesses Remaining: " + (MAX_GUESSES - numGuesses)/2);
                    }
                }
            }
            else
            {
                System.out.println("You have already guessed that letter.");
            }
        }
        else if(guess != null && guess.length() == word.length() && guess.equals(word))
        {
            guessedLetters = word;
            System.out.println(guessedLetters);
            System.out.println("You guessed correctly. The word was '" + word + "'.");
        }
        else if(guess != null && guess.length() == word.length() && !guess.equals(word))
        {
            if(word.length() >= MAX_GUESSES)
            {
                numGuesses += 2;
            }
            else if(word.length() < MAX_GUESSES)
            {
                numGuesses += 4;
            }
            makePicture();
            System.out.println(guessedLetters);
            System.out.println("You guessed incorrectly. The word isn't '" + guess + "'.");
            if(gold > 0)
            {
                gold -= 2;
                System.out.println("You lost 1 gold.");
                System.out.println("You now have " + gold + " gold.");
            }
        }
        else if(guess == null)
        {
            return;
        }
        else
        {
            System.out.println("You must input either one valid character or the entire word.");
        }
    }

    /**
     * Displays the word one is guessing with the correctly guessed letters now filled in.
     */
    private void display()
    {
        System.out.println("\f");
        if(word.indexOf(guess) == word.lastIndexOf(guess))
        {
            guessedLetters = guessedLetters.substring(0, word.indexOf(guess)) + guess + guessedLetters.substring(word.indexOf(guess) + 1, gl);
            unusedLetters();
            System.out.println(guessedLetters);
            System.out.println(unusedLetters);
            System.out.println("Incorrect Guesses Remaining: " + (MAX_GUESSES - numGuesses));
            usedLetters = usedLetters + guess;
            System.out.println("You guessed correctly. '" + guess.toUpperCase() + "' was in the word.");
            gold += 1;
            System.out.println("You gained 1 gold.");
            System.out.println("You now have " + gold + " gold.");
        }
        else if(word.indexOf(guess) != word.lastIndexOf(guess))
        {
            multipleOfSameLetter();
            unusedLetters();
            System.out.println(guessedLetters);
            System.out.println(unusedLetters);
            System.out.println("Incorrect Guesses Remaining: " + (MAX_GUESSES - numGuesses));
            usedLetters = usedLetters + guess;
            System.out.println("You guessed correctly. '" + guess.toUpperCase() + "' was in the word.");
            gold += 2;
            System.out.println("You gained 2 gold.");
            System.out.println("You now have " + gold + " gold.");
        }

    }

    /**
     * Displays the letters that one has yet to guess.
     */
    private void unusedLetters()
    {
        if(unusedLetters.indexOf(guess) > -1)
        {
            unusedLetters = unusedLetters.substring(0, unusedLetters.lastIndexOf(guess)) +  unusedLetters.substring(unusedLetters.lastIndexOf(guess) + 1, unusedLetters.length());
        }
    }

    /**
     * Makes the picture depending on how many incorrect guesses one has.
     */
    private void makePicture()
    {
        System.out.println("\f");
        if(numGuesses == 1)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 2)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 3)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 4)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 5)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 6)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 7)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("       | |   _                | |  ");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 8)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("       | |   _____            | |  ");
            System.out.println("     |-| |-- _ ---------------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 9)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("       | |   _________        | |  ");
            System.out.println("     |-| |-- _____ -----------| |-|");
            System.out.println("     |-| |-- _ ---    --------| |-|");
            System.out.println("     |-| |--------    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 10)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("       | |   _____________    | |  ");
            System.out.println("     |-| |---_________ -------| |-|");
            System.out.println("     |-| |-- _____    --------| |-|");
            System.out.println("     |-| |-- _ ---    --------| |-|");
            System.out.println("     |-| |--------------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses == 11)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |   ______||______   | |  ");
            System.out.println("     |-| |---__________ ------| |-|");
            System.out.println("     |-| |---_________ -------| |-|");
            System.out.println("     |-| |-- _____    --------| |-|");
            System.out.println("     |-| |-- _ ---------------| |-|");
            System.out.println("     | | |                    | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
        if(numGuesses >= MAX_GUESSES)
        {
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | |                    | |  ");
            System.out.println("       | |                    | |  ");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("     ------------------------------");
            System.out.println("       | | --------||-------- | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("       | |         ||         | |  ");
            System.out.println("     |-| |---______||______---| |-|");
            System.out.println("     |-| |---__________ ------| |-|");
            System.out.println("     |-| |---_________ -------| |-|");
            System.out.println("     |-| |-- _____ -----------| |-|");
            System.out.println("     | | |   _                | | |");
            System.out.println("_____| | |____________________| | |_____");
        }
    }

    /**
     * Sets up the game by choosing what word to use and making a blank word made of dashes equal in length to the word one must guess.
     */
    private void setUp()
    {
        System.out.println("\f");
        hint = "";
        hintCount = 0;
        makeWord();
        guessedLetters = "";
        unusedLetters = "Unused Letters: a b c d e f g h i j k l m n o p q r s t u v w x y z";
        usedLetters = "";
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        l = word.length();
        gl = guessedLetters.length();
        while(gl < l)
        {
            guessedLetters = guessedLetters + "-";
            gl = guessedLetters.length();
        }
        System.out.println("Guess a single valid character and attempt to get the word filled in. If you feel like guessing the entire word you can but if you get it wrong it will count as two wrong guesses. Also, pressing cancel or inputting a blank answer will quit the game.");
    }

    /**
     * Fills in the blank word when a letter appears multiple times.
     */
    private void multipleOfSameLetter()
    {
        int c = 0;
        if(word.indexOf(guess) != -1)
        {
            c = word.indexOf(guess);
            guessedLetters = guessedLetters.substring(0, word.indexOf(guess)) + guess + guessedLetters.substring(word.indexOf(guess) + 1, gl);
            while(c != word.lastIndexOf(guess))
            {
                c = word.indexOf(guess, c + 1);
                guessedLetters = guessedLetters.substring(0, c) + guess + guessedLetters.substring(c + 1, gl);
            }
        }
    }

    /**
     * Word bank
     */
    private void makeWord()
    {
        Random rand = new Random();
        int chooseWord = rand.nextInt(28) + 1;
        if(chooseWord == 1)
        {
            word = "honorificabilitudinitatibus";
            hint = "The state of being able to achieve honors(Latin)";
        }
        else if(chooseWord == 2)
        {
            word = "supercalifragilisticexpialidocious";
            hint = "A song in Mary Poppins";
        }
        else if(chooseWord == 3)
        {
            word = "pseudopseudohypoparathyroidism";
            hint = "Seeming to have resistance to the parathyroid hormone, but being biochemically normal";
        }
        else if(chooseWord == 4)
        {
            word = "anime";
            hint = "Japanese animation";
        }
        else if(chooseWord == 5)
        {
            word = "manga";
            hint = "Japanese comics";
        }
        else if(chooseWord == 6)
        {
            word = "ajar";
            hint = "To be left open";
        }
        else if(chooseWord == 7)
        {
            word = "guillotine";
            hint = "An item used for execution";
        }
        else if(chooseWord == 8)
        {
            word = "plethora";
            hint = "An excessive amount";
        }
        else if(chooseWord == 9)
        {
            word = "quantum";
            hint = "A discrete quantity of energy proportional in magnitude to the frequency of the radiation it represents";
        }
        else if(chooseWord == 10)
        {
            word = "java";
            hint = "A coding language";
        }
        else if(chooseWord == 11)
        {
            word = "hadron";
            hint = "A subatomic particle of a type including the baryons and mesons that can take part in the strong interaction";
        }
        else if(chooseWord == 12)
        {
            word = "serendipity";
            hint = "The occurrence of beneficial accidents";
        }
        else if(chooseWord == 13)
        {
            word = "amaterasu";
            hint = "A godess of the sun in a certain religion";
        }
        else if(chooseWord == 14)
        {
            word = "izanami";
            hint = "A godess of creation in a certain religion";
        }
        else if(chooseWord == 15)
        {
            word = "izanagi";
            hint = "A god of creation in a certain religion";
        }
        else if(chooseWord == 16)
        {
            word = "trek";
            hint = "A journey";
        }
        else if(chooseWord == 17)
        {
            word = "hangman";
            hint = "A guessing game";
        }
        else if(chooseWord == 18)
        {
            word = "untranslatability";
            hint = "Can't be translated";
        }
        else if(chooseWord == 19)
        {
            word = "america";
            hint = "A capitalist country";
        }
        else if(chooseWord == 20)
        {
            word = "japan";
            hint = "An island nation";
        }
        else if(chooseWord == 21)
        {
            word = "execution";
            hint = "Carrying out a death sentence";
        }
        else if(chooseWord == 22)
        {
            word = "karel";
            hint = "A robot that can place beepers";
        }
        else if(chooseWord == 23)
        {
            word = "anybeepersinbeeperbag";
            hint = "A method for karel with an adjective that isn't needed";
        }
        else if(chooseWord == 24)
        {
            word = "floccinaucinihilipilification";
            hint = "The action of estimating something as worthless";
        }
        else if(chooseWord == 25)
        {
            word = "word";
            hint = "A single meaningful element of speech or writing used to make up a sentence";
        }
        else if(chooseWord == 26)
        {
            word = "kludge";
            hint = "To do something the wrong way";
        }
        else if(chooseWord == 27)
        {
            word = "courtney";
            hint = "A common middle name or a girl's first name";
        }
        else if(chooseWord == 28)
        {
            word = "czechoslovakia";
            hint = "A country with a name that is fun to pronounce";
        }
    }
}
