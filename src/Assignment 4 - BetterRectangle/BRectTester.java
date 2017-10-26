/*==============================================================================  
|   Source code:    [name of the source code file – i.e. TestDriver.java]
|   Author:         Luis Vitier
|   Student ID:     5723008 
|   Assignment:     Program #4 - Better Rectangle
|  
|   Course:     COP 3337 (Programming 2)
|   Section:    U09 
|   Instructor: William Feild  
|   Due Date:   26 October 2017, at the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:       Java 8
|   Compile/Run:
| 	javac BRectTester.java BetterRectangle.java
|   java BRectTester
| 
+-------------------------------------------------------------------------------  
|  
|   Description:    The goal of this program is to reinvent the rectangle
|                   class and fix some of its shortcomming.
|                  
|   Input:          No user input
|  
|   Output:         The user should expect the toString output of all tested
|                   rectangles and any other relevant information pertaining to
|                   the specific rectangles being tested.
|  
|   Process:        The BetterRectangle class makes extensive use of basic
|                   geometric formulas that were provided in the specifications
|                   by professor William Feild.
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

public class BRectTester
{
    //These rectangles and values are specified in the specifications.
    private static BetterRectangle bRectA = new BetterRectangle(4,3);
    private static BetterRectangle bRectB = new BetterRectangle(bRectA);
    private static BetterRectangle bRectC = new BetterRectangle(1,1,3,4);
    private static BetterRectangle bRectD = new BetterRectangle();

    public static void main(String[] args)
    {
        System.out.println(bRectA);
    }
}