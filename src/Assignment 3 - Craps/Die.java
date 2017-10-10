/*==============================================================================
|   Source code:    Die.java
|   Class:          Die
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #3 - Craps
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   12 October, 2017, by the beginning of class.
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
|   Purpose:        This class exists to satisfy the requirement of a Die.java
|                   file.
|
|   Inherits From:  None
|
|   Interfaces:     None
|
+-------------------------------------------------------------------------------
|
|   Constants:  There are no class constants
|
+-------------------------------------------------------------------------------
|
|   Constructors:       No constructors
|
|   Class Methods:      There are no private methods.
|
|   Instance Methods:   There are no instance methods
|
*=============================================================================*/

public class Die
{
    /*
     * Method for simulating rolling a single Die. Assigns a random value
     * between 1 and sides, the minimum and maximum outcomes of a die roll
     * respectively.
     */
    public static int rollDie(int sides)
    {
        final int DIE_MINIMUM = 1;
        return (int)(Math.random() * sides + DIE_MINIMUM);
    }
}