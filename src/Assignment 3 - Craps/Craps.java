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
|   Purpose:        This class exists to simulate the game of craps and keep
|                   track of all the data. The game is living and breathing
|                   and the instance variables help with the data needed in
|                   the program later on.
|
|   Inherits From:  None
|
|   Interfaces:     None
|
+-------------------------------------------------------------------------------
|
|   Constants:  No public class constants
|
+-------------------------------------------------------------------------------
|
|   Constructors:   1 constructor: Craps, takes no arguments and instantiates
|                   the field variables.
|
|   Class Methods:  void resetGame() takes no arguments,
|                   void endGame() takes two boolean and an int,
|                   int rollDice() takes two ints,
|                   void updateTally() takes one int
|
|   Instance Methods:
|                   void playGame() takes two ints,
|                   int getTotalGamesCount() takes no arguments,
|                   int getTotalDieRolls() takes no arguments,
|                   int[] getTally() takes no arguments,
|                   double averageLength() takes no arguments,
|                   double winningOutcome() takes no arguments,
|                   int getOpeningWins() takes no arguments,
|                   double openingWinsOutcome() takes no arguments,
|                   int getOpeningLoses() takes no arguments,
|                   double openingLosesOutcome() takes no arguments,
|                   double openingGameEndOutcome() takes no arguments,
|                   int getLongestGame() takes no arguments
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
        final int MAX_TALLY = 22;   //We are only keeping track of games that
        // go up to 21.
        if (tally.length < MAX_TALLY)
        {


            final int[] temp = tally;
            tally = new int[temp.length + 1];

            System.arraycopy(temp, 0, tally, 0, temp.length);

            tally[tally.length - 1] = rolls;
        }
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
     * Method for calculating the outcome probability of winning on the
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


    /**
     * Method for calculating the outcome probability of losing on the coming
     * out
     *
     * @return      openingLoses/openingGames
     */
    public double openingLosesOutcome()
    {
        return  (((double) openingLoses) / ((double) (openingGames))) * 100.0;
    }


    /**
     * Method for calculating the outcome probability of the game ending at
     * the coming out
     *
     * @return      openingGames / totalGamesCount
     */
    public double openingGameEndOutcome()
    {
        return (((double) (openingGames)) / ((double) totalGamesCount)) * 100.0;
    }


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