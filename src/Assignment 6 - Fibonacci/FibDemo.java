/*==============================================================================  
|   Source code:    [name of the source code file – i.e. TestDriver.java]
|   Author:         Luis Vitier
|   Student ID:     5723008 
|   Assignment:     Program #6 Fibonacci
|  
|   Course:     COP 3337 (Programming 2)
|   Section:    U09 
|   Instructor: William Feild  
|   Due Date:   December 7, 2017, at the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:       Java 8
|   Compile/Run:    [How to Compile and Execute this program, IN DETAIL.] 
| 	javac xxx.java yyy.java java xxx
| 
+-------------------------------------------------------------------------------  
|  
|   Description:    [Describe the program's goal, IN DETAIL.]  
|                  
|   Input:          [Describe the sources and formats of all user-supplied input
|                   required by the program.]  
|  
|   Output:         [Describe the output that the user should expect the program
|                   to produce.]  
|  
|   Process:        [Names of standard algorithms employed, explanations of why
|                   things were done they way they were done, etc. This is the
|                   place for technical information that another programmer
|                   would like to know.]  
|  
|   Required Features Not Included:  
|                   [If the assignment specifies a feature that you were unable
|                   to include in the program, mention that omission here.
|                   Otherwise, state that you were able to include all of the
|                   required features in your program. Being honest here may
|                   save you some points.]  
|  
|   Known Bugs:     [If you know of any problems with the code, provide details
|                   here; otherwise, clearly state that you know of no logic
|                   errors. Being honest here may save you some points.]  
*=============================================================================*/

public class FibDemo
{
    public static void main(String[] args)
    {
        FibSequence fibo = new LoopFibSequence();
    }
}