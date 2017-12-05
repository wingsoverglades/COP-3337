/*==============================================================================
|   Source code:    FibSequence.java
|   Class:          FibSequence
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #7 - Fibonacci
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   12 December 2017, by the end of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac FibSequence.java
|	java
|
|   Purpose:        This class exists in order to provide a simple recursive
|                   solution to the Fibonacci sequence.
|
|   Inherits From:  None
|
|   Interfaces:     Sequence
|
+-------------------------------------------------------------------------------
|
|   Constants:      No class constants.
|
+-------------------------------------------------------------------------------
|
|   Constructors:       FibSequence() takes no arguments.
|
|   Class Methods:      No private class methods.
|
|   Instance Methods:   int fibonacci() takes one int argument, int next()
|                       takes no arguments.
|
*=============================================================================*/

public class FibSequence implements Sequence
{
    private int currentVal;
    private int currentIndx;


    /**
     * Default constructor for the FibSequence class.
     */
    public FibSequence()
    {
        currentIndx = 0;
        currentVal = 0;
    }


    /**
     * This method finds the fibonacci value at a given location in the
     * sequence.
     *
     * @param index     The index of the value we are looking for.
     * @return          The value of the index.
     */
    public int fibonacci(int index)
    {
        if (index == 0)
        {
            return 0;
        }
        if (index == 1)
        {
            return 1;
        }

        return fibonacci(index - 1) + fibonacci( index - 2);
    }


    /**
     * This method is a mutator for the instance variables.
     *
     * @return      currentVal.
     */
    @Override
    public int next()
    {
        currentVal = this.fibonacci(++currentIndx);
        return currentVal;
    }
}