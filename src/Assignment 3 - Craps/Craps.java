/*==============================================================================
|   Source code:    Craps.java
|   Class:          Craps
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #3 - Craps
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   12 October, 2017, by the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac Analyzer.java Craps.java Die.java
|	java Analyzer
|
|   Purpose:        [A description of why this class exists.  For what
|                   reason was it written?  Which jobs does it perform?]
|
|   Inherits From:  The object class.
|
|   Interfaces:     None
|
+-------------------------------------------------------------------------------
|
|   Constants:  [Name all public class constants, and provide a very
|                   brief (but useful!) description of each.]
|
+-------------------------------------------------------------------------------
|
|   Constructors:  [List the names and arguments of all defined
|                   constructors.]
|
|   Class Methods:  [List the names, arguments, and return types of all
|                   private class methods.]
|
|   Instance Methods:  [List the names, arguments, and return types of all
|                   public instance methods.]
|
*=============================================================================*/

public class Craps
{
    private int totalGamesCount;
    private int totalDieRolls;
    private int tally[];
    private int openingWins;
    private int openingLoses;
    private int longestGame;

    private final int NATURAL = 7;
    private final int YO_LEVEN = 11;
    private final int SNAKE_EYES = 2;
    private final int ACE_DEUCE = 3;
    private final int BOX_CARS = 12;

    private int point;
    private int currentRolls;


    /**
     * Constructor for the Craps class. Takes no arguments and returns no
     * values.
     */
    public Craps()
    {
        totalGamesCount = 0;
        totalDieRolls = 0;
        tally = new int[0];
        openingWins = 0;
        openingLoses = 0;
        longestGame = 0;

        point = 0;
        currentRolls = 0;
    }


    /**
     * Method for actually playing the game. Implements the rules for
     * non-betting Craps.
     *
     * @param dice      The number of dice we are playing with.
     * @param sides     The number of sides each die have.
     */
    public void playGame(int dice, int sides)
    {
        resetGame();

        point = rollDice(dice, sides);
        boolean continue_state = true;  //The game continues by default.

        if (point == NATURAL || point == YO_LEVEN)
        {
            endGame(true, true, currentRolls);
            continue_state = false; //stop game
        }
        else if (point == SNAKE_EYES || point == ACE_DEUCE || point == BOX_CARS)
        {
            endGame(false, true, currentRolls);
            continue_state = false; //stop game
        }

        if (continue_state)
        {
            int currentTurn;

            do {
                currentTurn = rollDice(dice,sides);
                if (currentTurn == point)
                {
                    endGame(true,false,currentRolls);
                }
                else if (currentTurn == NATURAL)
                {
                    endGame(false,false,currentRolls);
                }
            } while (currentTurn != 7 && currentTurn != point);
        }   //end if
    }


    /**
     *  Method for resetting the game. Makes sure no variables have weird
     *  values at the start of the game.
     */
    private void resetGame()
    {
        currentRolls = 0;
        point = 0;
    }


    /**
     *
     */
    private void endGame(boolean won, boolean opening, int rolls)
    {
        totalGamesCount++;
        updateTally(rolls);

        if (won && opening)
        {
            openingWins++;
        }   //end if
        if (!won && opening)
        {
            openingLoses++;
        }   //end if

        if (rolls > longestGame)
        {
            longestGame = rolls;
        }   //end if
    }


    /**
     * Rolls the specified number of dice with the specified number of faces
     * and returns the addition of their results.
     *
     * @param dice      Number of dice needed for the game.
     * @param sides     Number of sides per die.
     *
     * @return          Sum of the die rolls.
     */
    private int rollDice(int dice, int sides)
    {
        int sum = 0;    //Start at 0 in order to simplify addition.

        for (int i = 0; i < dice; i++)
        {
            sum += Die.rollDie(sides);
        }   //end loop

        totalDieRolls += dice;
        currentRolls += dice;
        return sum;
    }


    /**
     * Calculates the average length for a game of craps.
     *
     * @return          The total rolls for all the games divided by the
     *                  total games played.
     */
    public double averageLength()
    {
        return ((double) totalDieRolls / (double) totalGamesCount);
    }


    /**
     * Updates the tally with the new score
     *
     * @param rolls     The number of rolls for the game to finish.
     */
    private void updateTally(int rolls)
    {
        final int MAX_ROLLS = 21;   //We are only keeping track of games that
                                    // go up to 21.
        if (rolls > MAX_ROLLS)
        {
            rolls = MAX_ROLLS;
        }   //end if

        final int[] temp = tally;
        tally = new int[temp.length + 1];

        System.arraycopy(temp, 0, tally, 0, temp.length);

        tally[tally.length - 1] = rolls;
    }
}