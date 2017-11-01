/*==============================================================================
|   Source code:    PrimeSequence.java
|   Class:          PrimeSequence
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #n - name
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   1 January 2000, by the end of class 
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac PrimeSequence.java
|	java PrimeSequence
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

public class PrimeSequence implements Sequence
{
    /**
     * This method finds the next prime number.
     * @param number    Find the next element after this value.
     * @return          The next prime number after the argument.
     */
    @Override
    public long next(long number)
    {

    }

    /**
     * This method determines whether or not a number is prime
     *
     * @param number    The number being tested
     * @return          True if the number is prime, false otherwise.
     */
    public boolean isPrime(long number)
    {
        if (number == 2)
        {
            return true;
        }

        for (int i = 2; i < (int)Math.sqrt(number) + 1; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}