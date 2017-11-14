/*==============================================================================
|   Source code:    Sequence.java
|   Class:          Sequence
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #6 - Sequence of Primes
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   December 7, 2017, by the beggining of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac Sequence.java
|	java
|
|   Purpose:        This interface exists to provide the template for a
|                   Sequence of numbers.
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
|                   int next() takes no parameters.
|
*=============================================================================*/

public interface Sequence
{
    /**
     * This interface method finds the next element in the sequence.
     *
     * @return          The value of the next element.
     */
    int next();
}