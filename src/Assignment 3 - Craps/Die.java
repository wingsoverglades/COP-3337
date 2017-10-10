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
|   Constants:  There are no class constants
|
+-------------------------------------------------------------------------------
|
|   Constructors:       Public constructor Die, takes no arguments.
|
|   Class Methods:      There are no private methods.
|
|   Instance Methods:   There are Two (2) public instance methods: method
|                       rollDie takes no arguments and returns no values,
|                       method getDieValue takes no arguments and returns the
|                       value of the variable "face."
|
*=============================================================================*/

public class Die
{
    private int value;
    private final int DIE_SIDES;

    /*
     * Constructor for the Die class. Takes 1 argument: the number of sides
     * in the die, and returns no values other than the Die it creates.
     */
    public Die(int sides)
    {
        DIE_SIDES = sides;
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
        value = (int)(Math.random() * DIE_SIDES + DIE_MINIMUM);
    }


    /*
     * Getter method that returns the value of value.
     */
    public int getDieValue()
    {
        return value;
    }
}