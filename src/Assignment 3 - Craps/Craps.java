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
    private int totalWins;
    private int openingGames;
    private int openingWins;
    private int openingLoses;
    private int longestGame;

    private int point;
    private int currentRolls;

    private final int NATURAL = 7;
    private final int YO_LEVEN = 11;
    private final int SNAKE_EYES = 2;
    private final int ACE_DEUCE = 3;
    private final int BOX_CARS = 12;


    /**
     * Constructor for the Craps class. Takes no arguments and returns no
     * values.
     */
    public Craps()
    {
        totalGamesCount = 0;
        totalDieRolls = 0;
        tally = new int[0];
        totalWins = 0;
        openingGames = 0;
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
                if (currentTurn == point) {
                    endGame(true,false,currentRolls);
                }   //end if
                else if (currentTurn == NATURAL) {
                    endGame(false,false,currentRolls);
                }   //end if
            } while (currentTurn != 7 && currentTurn != point); // end loop
        }   //end if
    }


    /**
     * Method for resetting the game. Makes sure no variables have weird
     * values at the start of the game.
     */
    private void resetGame()
    {
        point = 0;
        currentRolls = 0;
    }


    /**
     * Method that handles all the end game possibilities.
     *
     * @param won       A boolean type, true if the shooter won the game, false
     *                  if the shooter lost.
     * @param opening   A boolean type, true if the game got resolved in the
     *                  coming out play, regardless of whether or not the
     *                  shooter won.
     */
    private void endGame(boolean won, boolean opening, int rolls)
    {
        totalGamesCount++;
        totalDieRolls += currentRolls;
        updateTally(rolls);

        if(won)
        {
            totalWins++;
        }

        if(opening)
        {
            openingGames++;
        }

        if (won && opening)
        {
            openingWins++;
        }   //end if
        else if (!won && opening)
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

        currentRolls += dice;
        return sum;
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


    /**
     * Getter method for totalGamesCount
     *
     * @return      totalGamesCount
     */
    public int getTotalGamesCount()
    {
        return totalGamesCount;
    }


    /**
     * Getter method for totalDieRolls
     *
     * @return      totalDieRolls
     */
    public int getTotalDieRolls()
    {
        return totalDieRolls;
    }

    /**
     * Getter method for tally
     *
     * @return      tally
     */
    public int[] getTally()
    {
        return tally;
    }


    /**
     * Calculates the average length for a game of craps.
     *
     * @return          The total rolls for all the games divided by the
     *                  total games played.
     */
    public double averageLength()
    {
        return (((double) totalDieRolls) / ((double) totalGamesCount));
    }


    /**
     * Method for determining the winning probability overall.
     *
     * @return      totalWins/totalGames
     */
    public double winningOutcome()
    {
        return (((double) totalWins) / ((double) totalGamesCount)) * 100.0;
    }


    /**
     * Getter method for openingWigs
     *
     * @return      openingWins
     */
    public int getOpeningWins()
    {
        return openingWins;
    }


    /**
     * Method for calculating the the outcome probability of winning on the
     * coming out.
     *
     * @return      openingWins/openingGames
     */
    public double openingWinsOutcome()
    {
        return (((double) openingWins) / ((double) (openingGames))) * 100.0;
    }


    /**
     * Getter method for openingLoses
     *
     * @return      openingLoses
     */
    public int getOpeningLoses()
    {
        return openingLoses;
    }


    /*public double openingGameEnd()
    {

    }*/


    /**
     * Getter method for longestGame
     *
     * @return      longestGame
     */
    public int getLongestGame()
    {
        return longestGame;
    }
}