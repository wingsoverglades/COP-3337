/*==============================================================================  
|   Source code:    Analyzer.java
|   Author:         Luis Vitier
|   Student ID:     5723008 
|   Assignment:     Program #3 Craps
|  
|   Course:     COP 3337 (Programming 2)
|   Section:    U09 
|   Instructor: William Feild  
|   Due Date:   October 12, 2017, at the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:       Java 8
|   Compile/Run:
| 	javac Analyzer.java Craps.java Die.java
|   java Analyzer
| 
+-------------------------------------------------------------------------------  
|  
|   Description:    The Program's goal is to simulate a game of non-betting
|                   craps and using the moves to display data about the
|                   probabilities in the game.
|                  
|   Input:          The user inputs a number from 1 to 1,000,000 which is
|                   used to determine the number of games to run.
|  
|   Output:         The user should expect: total number of games, total
|                   number of rolls, a tally of the 22 first games, average
|                   length of rolls, probability of winning, total number of
|                   wins in the opening, probability of winning in the
|                   opening, total number of loses in opening, probability of
|                   losing in the opening, probability of the games ending on
|                   the coming out, probability of the games continuing after
|                   the coming up, longest game played
|  
|   Process:        This tester file itself does not have much in the way of
|                   algorithms. The only algorith of note is the for loop
|                   used to print the contents of the tally array which is a
|                   standard array iteration.
|  
|   Required Features Not Included:  
|                   None of the expected probability cases were implemented.
|  
|   Known Bugs:     No known bugs
*=============================================================================*/

import java.util.Scanner;   //Provides the scanner utility for user input.

public class Analyzer
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("How much crap do you want to shoot?");
        System.out.print("Please enter and integer between 1 and 1,000,000, " +
                "inclusive: ");

        //Get user input and validate for the 1 - 1,000,000 inclusive limit.
        long count = input.nextLong();
        if (count < 1)
        {
            count = 1;
        }   //end if
        if (count > 1000000)
        {
            count = 1000000;
        }   //end if

        Craps game = new Craps();

        for (long i = 0; i < count; i++)
        {
            game.playGame(2, 6);
        }

        // 1
        System.out.println("Total number of games played: "
                + game.getTotalGamesCount());
        // 2
        System.out.println("Total number of rolls for all games: "
                + game.getTotalDieRolls());
        // 3
        for(int i = 0; i < game.getTally().length; i++)
        {
            System.out.println("Tally for game " + (i + 1) + ": "
                    + game.getTally()[i]);
        }
        // 4
        System.out.printf("Average length of the games played: %.5f\n",
                game.averageLength());

        // 5 TODO
        System.out.println("Expected probability of winning overall: " +
                "UNIMPLEMENTED");
        // 6
        System.out.printf("Probability of winning: %.5f%%\n",
                game.winningOutcome());

        // 7
        System.out.println("Total number of wins that occurred on the coming "
                + "out roll: " + game.getOpeningWins());

        // 8 TODO
        System.out.println("Expected probability of winning on the coming out"
                + " roll: UNIMPLEMENTED");
        // 9
        System.out.printf("Probability of winning on coming out: %.5f%%\n",
                game.openingWinsOutcome());

        // 10
        System.out.println("Total number of loses that occurred on the coming "
                + "out roll: " + game.getOpeningLoses());

        // 11 TODO
        System.out.println("Expected probability of losing on the coming out "
                + "roll: UNIMPLEMENTED");
        // 12
        System.out.printf("Probability of losing on coming out: %.5f%%\n",
                game.openingLosesOutcome());

        //13 TODO
        System.out.println("Expected probability of the games ending (win or"
                + " loss) on the coming out roll: UNIMPLEMENTED");
        //14
        System.out.printf("Probability of game ending on coming out: %.5f%%\n",
                game.openingGameEndOutcome());

        //15 TODO
        System.out.println("Expected probability of the game continuing after"
                + " the coming out roll: UNIMPLEMENTED");
        //16
        System.out.printf("Probability of game continuing past coming out: "
                + "%.5f\n", Math.abs(game.openingGameEndOutcome() - 100.0));

        //17
        System.out.println("Longest game played: " + game.getLongestGame());
    }
}