/*==============================================================================
|   Source code:    FastFibSequence.java
|   Class:          FastFibSequence
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #6 - Fibonacci
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   12 December 2017, by the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac FibDemo.java FastFibSequence.java
|	java
|
|   Purpose:  [A description of why this class exists.  For what
|                   reason was it written?  Which jobs does it perform?]
|
|   Inherits From:  [If this class is a subclass of another, name it.
|                   If not, just say "None."]
|
|   Interfaces:  [If any predefined interfaces are implemented by
|                  this class, name them.  If not, ... well, you know.]
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

public class FastFibSequence extends FibSequence implements Sequence
{
    private int currentVal;
    private int currentIndx;


    /**
     * Default constructor for the FastFibSequence class.
     */
    public FastFibSequence()
    {
        currentIndx = 0;
        currentVal = 0;
    }


    /**
     * Wrapper method for the fibonacciCore class, Exists in order to ease
     * calling and to maintain object hierarchy.
     * @param index     The index of the fibonacci number to be found.
     * @return          The fibonacci number at index.
     */
    @Override
    public int fibonacci(int index)
    {
        return fibonacciCore(index, 0, 1);
    }


    /**
     * This method finds the fibonacci value at a given location in the
     * sequence. This method uses tail recursion in order to get better
     * performance over a regular recursive function.
     *
     * @param index     The index of the value we are looking for originally,
     *                  after every recursive call this becomes the number of
     *                  calls left to do in order to find the answer.
     * @param p1        The previous fibonacci number. Function must be
     *                  called with p1 = 0.
     * @param p2        The addition of the two previous fibonacci numbers.
     *                  Function must be called with p2 = 1.
     * @return          The value of the index.
     */
    private int fibonacciCore(int index, int p1, int p2)
    {
        if(index == 0)
        {
            return p1;
        }
        if(index == 1)
        {
            return p2;
        }

        return fibonacciCore(index - 1, p2, p1 + p2);
    }


    /**
     * This method is a mutator for the instance variables.
     *
     * @return      current_val.
     */
    @Override
    public int next()
    {
        currentVal = this.fibonacci(++currentIndx);
        return currentVal;
    }
}