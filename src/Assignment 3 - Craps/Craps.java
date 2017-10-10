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

import java.util.ArrayList;

public class Craps
{
        private int gamesCount;
        private int totalDieRolls;
        private int tally[];
        private int openingWins;
        private int openingLoses;



        /**
         * Constructor for the Craps class. Takes no arguments and returns no
         * values.
         */
        public Craps()
        {
            gamesCount = 0;
            totalDieRolls = 0;
            tally = new int[0];
            openingWins = 0;
            openingLoses = 0;
        }

}