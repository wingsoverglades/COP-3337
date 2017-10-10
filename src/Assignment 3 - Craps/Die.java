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
|   Purpose:        This class exists to simulate the behavior of a single Die.
|                   It is general purpose.
|
|   Inherits From:  the "Object" class
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
|   Constructors:   Public constructor Die, takes no arguments.
|
|   Class Methods:  [List the names, arguments, and return types of all
|                   private class methods.]
|
|   Instance Methods:  [List the names, arguments, and return types of all
|                   public instance methods.]
|
*=============================================================================*/

public class Die
{
    private int face;

    /*
     * Constructor for the Die class. Takes no arguments and returns no
     * values other than the Die it creates.
     */
    public Die()
    {
        rollDie();
    }


    /*
     * Method for simulating rolling a single Die. Assigns a random value
     * between 1 and 6, the minimum and maximum outcomes of a die roll
     * respectively.
     */
    public void rollDie()
    {
        final int DIE_MINIMUM = 1;
        final int DIE_MAXIMUM = 6;
        face = (int)(Math.random() * DIE_MAXIMUM + DIE_MINIMUM);
    }


    /*
     * Getter method that returns the value of face.
     */
    public int getDieValue()
    {
        return face;
    }
}