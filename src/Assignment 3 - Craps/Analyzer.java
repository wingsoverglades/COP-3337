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

        //Tier 1 of output
        System.out.println("Total number of games played: "
                + game.getTotalGamesCount());
        System.out.println("Total number of rolls for all games: "
                + game.getTotalDieRolls());
        for(int i = 0; i < game.getTally().length; i++)
        {
            System.out.println("Tally for game " + i + ": "
                    + game.getTally()[i]);
        }
        System.out.printf("Average length of the games played: %.5f\n",
                game.averageLength());

        //Tier 2 of output
        System.out.println("Expected probability of winning overall: ");
        System.out.printf("Probability of winning: %.5f%%\n",
                game.winningOutcome());

        //Tier 3 of output
        System.out.println("Total");
    }
}