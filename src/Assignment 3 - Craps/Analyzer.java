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
        long games = input.nextLong();
        if(games < 1)
        {
            games = 1;
        }   //end if
        if(games > 1000000)
        {
            games = 1000000;
        }   //end if


    }
}