/*==============================================================================
|   Source code:    ComputePI.java
|   Author:         Luis Vitier
|   Student ID:     5723008
|   Assignment:     Program #1 Compute PI
|
|   Course:     COP 3337 Programming 2
|   Section:    U09
|   Instructor: William Feild
|   Due Date:  September 7, 2017, at the beginning of class
|
|   I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|
|	______________________________________ [Signature]
|
|   Language:       Java Programming Language
|   Compile/Run:    javac ComputePI.java && java ComputePI
|
+-------------------------------------------------------------------------------
|
|   Description:    The Program's goal is to calculate PI to
|                   7 significant digits.
|
|   Input:          None
|
|   Output:         The user should expect: the calculated value of PI, the
|                   accepted value of PI, and the number of iterations to find
|                   that value of PI.
|
|   Process:        The algorithm uses a variant of a Taylor's Series to
|                   approximate PI. Most of the variables and constants were
|                   created to conform to code style. Every iteration changes
|                   the operation from an addition to a subtraction and
|                   vice-versa. The denominator is incremented by 2.0 every loop
|                   and the variables in the actual calculation are doubles in
|                   order to maintain type safety.
|
|   Required Features Not Included:
|                   All the required features present.
|
|   Known Bugs:     I know of no logic errors except perhaps a high amount of
                    iterations.
*==============================================================================*/

import java.lang.Math;

public class ComputePI
{
    public static void main(String args[])
    {
        double currentPiApproximation = 4.0;
        double previousPiApproximation = 0.0;
        double denominator = 3.0;
        long iterations = 0;
        boolean operandDecider = false;

        final double NUMERATOR = 1.0;
        final double DENOMINATOR_STEP = 2.0;
        final double DELTA = 0.0000001; //Yes, I know it is ironic that my delta is constant.
        final int MASTER_MAGNIFIER = 4;

        while (Math.abs(currentPiApproximation - previousPiApproximation) > DELTA)
        {
            previousPiApproximation = currentPiApproximation;

            if (operandDecider)
            {
                currentPiApproximation = ((previousPiApproximation / MASTER_MAGNIFIER)
                        + (NUMERATOR / denominator)) * MASTER_MAGNIFIER;
            }
            else
            {
                currentPiApproximation = ((previousPiApproximation / MASTER_MAGNIFIER)
                        - (NUMERATOR / denominator)) * MASTER_MAGNIFIER;
            }

            operandDecider = !operandDecider; //Flip operation for next iteration
            denominator += DENOMINATOR_STEP;
            iterations++;
        }

        System.out.println(currentPiApproximation);
        System.out.println(Math.PI);
        System.out.println(iterations);
    }
}
