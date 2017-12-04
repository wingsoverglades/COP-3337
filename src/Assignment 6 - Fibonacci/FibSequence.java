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
|   Due Date:   7 December 2017, by the end of class
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