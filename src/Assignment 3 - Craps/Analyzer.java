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
|   Description:    [Describe the program's goal, IN DETAIL.]  
|                  
|   Input:          [Describe the sources and formats of all user-supplied input
|                   required by the program.]  
|  
|   Output:         [Describe the output that the user should expect the program
|                   to produce.]  
|  
|   Process:        [Names of standard algorithms employed, explanations of why
|                   things were done they way they were done, etc. This is the
|                   place for technical information that another programmer
|                   would like to know.]  
|  
|   Required Features Not Included:  
|                   [If the assignment specifies a feature that you were unable
|                   to include in the program, mention that omission here.
|                   Otherwise, state that you were able to include all of the
|                   required features in your program. Being honest here may
|                   save you some points.]  
|  
|   Known Bugs:     [If you know of any problems with the code, provide details
|                   here; otherwise, clearly state that you know of no logic
|                   errors. Being honest here may save you some points.]  
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
            System.out.println("Tally for game " + i + ": "
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