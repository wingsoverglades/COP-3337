/*==============================================================================
|   Source code:    Sequence.java
|   Class:          Sequence
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
|   Language:  Java
|   Compile/Run: 
| 	javac SequenceDemo.java Sequence.java PrimeSequence.java
|	java SequenceDemo
|
|   Purpose:        This interface exists to provide the template for the
|                   PrimeSequence class.
|
|   Inherits From:  None
|
|   Interfaces:     None
|
+-------------------------------------------------------------------------------
|
|   Constants:  No constants
|
+-------------------------------------------------------------------------------
|
|   Constructors:   Class has no constructors
|
|   Class Methods:  No class methods
|
|   Instance Methods:
|                   long next() takes one long parameter.
|
*=============================================================================*/

public interface Sequence
{
    /**
     * This interface method finds the next element in the sequence.
     *
     * @return          The value of the next element.
     */
    static long next(long number)
    {
        return 0;
    }
}