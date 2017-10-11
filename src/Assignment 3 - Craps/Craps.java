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

        currentRolls = 0;
    }


    /**
     *
     */
    public void playGame(int dice, int faces)
    {

    }


    /**
     * A method for the "coming out" play that has special rules
     *
     * @return          A code 1-3: 1 means that the game was won in the
     *                  coming out move, 2 means that the game was lost in
     *                  the coming out move, and 3 means the game must go on.
     */
    private int comingOut(final int DICE, final int SIDES)
    {
        final int POINT = rollDice(DICE, SIDES);

        // Accepted names for opening rolls
        final int NATURAL = 7;
        final int YO_LEVEN = 11;
        final int SNAKE_EYES = 2;
        final int ACE_DEUCE = 3;
        final int BOX_CARS = 12;

        final int WIN = 1;
        final int LOSS = 2;
        final int CONTINUE = 3;

        if(POINT == NATURAL || POINT == YO_LEVEN)
        {
            return WIN;
        }   //end if
        else if(POINT == SNAKE_EYES || POINT == ACE_DEUCE || POINT == BOX_CARS)
        {
            return LOSS;
        }   //end if

        return CONTINUE;
    }


    /**
     *
     */
    public void resetGame()
    {
        currentRolls = 0;
    }


    /**
     *
     */
    private void endGame(boolean won, boolean opening, int rolls)
    {
        totalGamesCount++;
        updateTally(rolls);

        if(won && opening)
        {
            openingWins++;
        }
        if(!won && opening)
        {
            openingLoses++;
        }

        if(rolls > longestGame)
        {
            longestGame = rolls;
        }
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

        for(int i = 0; i < dice; i++)
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
        if(rolls > MAX_ROLLS)
        {
            rolls = MAX_ROLLS;
        }   //end if

        final int[] temp = tally;
        tally = new int[tally.length + 1];

        System.arraycopy(temp, 0, tally, 0, temp.length);

        tally[tally.length - 1] = rolls;
    }
}