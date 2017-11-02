/*==============================================================================
|   Source code:    PrimeSequence.java
|   Class:          PrimeSequence
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #5 - Sequence of Primes
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   November 9, 2017, by the end of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java 8
|   Compile/Run: 
| 	javac SequenceDemo.java Sequence.java PrimeSequence.java
|	java SequenceDemo
|
|   Purpose:        This class exists in order to provide methods to manage
|                   prime numbers.
|
|   Inherits From:  None
|
|   Interfaces:     This class implements the Sequence interface.
|
+-------------------------------------------------------------------------------
|
|   Constants:      No class constants.
|
+-------------------------------------------------------------------------------
|
|   Constructors:   No class constructors.
|
|   Class Methods:  No private class methods.
|
|   Instance Methods:
|                   No instance methods.
|
*=============================================================================*/

public class PrimeSequence implements Sequence
{
    /**
     * This method finds the next prime number.
     * @param number    Find the next element after this value.
     * @return          The next prime number after the argument.
     */
    public static long next(long number)
    {
        long temp = number + 1;

        while (!isPrime(temp))
        {
            temp++;
        }
        return temp;
    }

    /**
     * This method determines whether or not a number is prime
     *
     * @param number    The number being tested
     * @return          True if the number is prime, false otherwise.
     */
    public static boolean isPrime(long number)
    {
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