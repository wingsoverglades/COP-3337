/*==============================================================================
|   Source code:    Triangle.java
|   Class:          Triangle
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #2 - Tringle
|
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild
|   Due Date:  28, September 2017, by the end of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|
|   Language:  Java
|   Compile/Run:
| 	javac Triangle.java TriangleTester.java
|	java TriangleTester
|
|   Purpose:        This class exists to consolidate the behaviour of a triangle
|                   into an easy to work with general-purpose class.
|
|   Inherits From:  This class inherits from the Object class
|
|   Interfaces:     None
|
+-------------------------------------------------------------------------------
|
|   Constants:  No public class constants, three private class constants:
|               POINT1, POINT2 and POINT3, three arrays of doubles.
|
+-------------------------------------------------------------------------------
|
|   Constructors:       One constructor: Triangle, that takes three pairs of
|                       doubles.
|
|   Class Methods:      1 private method. move() takes one double array and 2
|                       doubles as arguments and has no output.
|
|   Instance Methods:   13 public methods. Triangle() takes 6 pairs of
|                       doubles and returns a Triangle object, getPoint1(),
|                       getPoint2() and getPoint3() take no arguments and
|                       return a double. sideLength() takes two double arrays
|                       and returns a double. angle() takes a double array and
|                       returns a double. perimeter() takes no arguments and
|                       returns a double. area() takes no arguments and returns
|                       a double. isEquilateral() takes no arguments and
|                       returns a boolean. isRight() takes no arguments and
|                       returns a boolean. incenter() takes no arguments and
|                       returns an array of doubles. centroid() takes no
|                       arguments and returns an array of doubles. center()
|                       takes no arguments and returns no data.
|
*=============================================================================*/

import java.util.Arrays;    //Utility package

public class Triangle
{
    private final double POINT1[];
    private final double POINT2[];
    private final double POINT3[];

    /*
     * Constructor for the Triangle object class. Takes three pairs of real
     * numbers.
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3,
                    double y3)
    {
        POINT1 = new double[]{x1,y1};
        POINT2 = new double[]{x2,y2};
        POINT3 = new double[]{x3,y3};
    }


    /*
     * Returns the values of POINT1
     */
    public double[] getPOINT1()
    {
        return POINT1;
    }


    /*
     * Returns the values of POINT2
     */
    public double[] getPOINT2()
    {
        return POINT2;
    }


    /*
     * Returns the values of POINT3
     */

    public double[] getPOINT3()
    {
        return POINT3;
    }


    /*
     * Moves the specified point by the specified offset
     */
    private void move(double[] p, double xOffset, double yOffset)
    {
        if(Arrays.equals(POINT1,p))
        {
            POINT1[0] += xOffset;
            POINT1[1] += yOffset;
        }
        else if(Arrays.equals(POINT2,p))
        {
            POINT2[0] += xOffset;
            POINT2[1] += yOffset;
        }
        else if(Arrays.equals(POINT3,p))
        {
            POINT3[0] += xOffset;
            POINT3[1] += yOffset;
        }
    }


    /*
     * Finds the length of a side using Pythagorean Theorem
     */
    public static double sideLength(double p1[], double p2[])
    {
        return Math.sqrt( Math.pow(p1[0] - p2[0], 2.0)
                        + Math.pow(p1[1] - p2[1], 2.0));
    }


    /*
     * Finds the angle at a point using the steps detailed in:
     * https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html
     */
    public double angle(double p[])
    {
        if (Arrays.equals(p, POINT1))
        {
            return Math.acos((Math.pow(sideLength(POINT1, POINT2),2.0)
                    + Math.pow(sideLength(POINT1, POINT3),2.0)
                    - Math.pow(sideLength(POINT2, POINT3),2.0))

                    /   (2.0 * sideLength(POINT1, POINT2)
                        * sideLength(POINT1, POINT3)))

                    * 180.0
                    / Math.PI;  // Radian conversion to degree
        }

        else if (Arrays.equals(p, POINT2))
        {
            return Math.acos((Math.pow(sideLength(POINT2, POINT1),2.0)
                    + Math.pow(sideLength(POINT2, POINT3),2.0)
                    - Math.pow(sideLength(POINT1, POINT3),2.0))

                    /   (2.0 * sideLength(POINT2, POINT1)
                        * sideLength(POINT2, POINT3)))

                    * 180.0
                    / Math.PI;  // Radian conversion to degree
        }

        else if (Arrays.equals(p, POINT3))
        {
            return Math.acos((Math.pow(sideLength(POINT3, POINT1),2.0)
                    + Math.pow(sideLength(POINT3, POINT2),2.0)
                    - Math.pow(sideLength(POINT2, POINT1),2.0))

                    /   (2.0 * sideLength(POINT3, POINT1)
                        * sideLength(POINT3, POINT2)))

                    * 180.0
                    / Math.PI;  // Radian conversion to degree
        }

        return 0.0;
    }


    /*
     * Finds and returns the perimeter of the Triangle by adding all the sides.
     */
    public double perimeter()
    {
        return sideLength(POINT1, POINT2) + sideLength(POINT1, POINT3)
                                         + sideLength(POINT2, POINT3);
    }


    /*
     * Finds the area of the Triangle using the steps provided in:
     * http://sciencing.com/area-scalene-triangle-10015426.html
     */
    public double area()
    {
        final double HALF_PERIMETER = perimeter() / 2.0;

        return Math.sqrt((HALF_PERIMETER - sideLength(POINT1,POINT2))
                * (HALF_PERIMETER - sideLength(POINT1,POINT3))
                * (HALF_PERIMETER - sideLength(POINT2,POINT3))
                * HALF_PERIMETER);
    }


    /*
     * Finds whether the Triangle is equilateral
     */
    public boolean isEquilateral()
    {
        return sideLength(POINT1, POINT2) == sideLength(POINT1, POINT3) &&
                sideLength(POINT1, POINT2) == sideLength(POINT2, POINT3);
    }


    /*
     * Finds whether the Triangle is a right triangle
     */
    public boolean isRight()
    {
        final double ACCEPTABLE_DELTA = 0.0001;

        return (Math.abs(angle(POINT1) - 90.0) < ACCEPTABLE_DELTA)
                || (Math.abs(angle(POINT2) - 90.0) < ACCEPTABLE_DELTA)
                || (Math.abs(angle(POINT3) - 90.0) < ACCEPTABLE_DELTA);
        // A right triangle is determined by the presence of a 90 degree angle.
    }


    /*
     * Finds the incenter of the triangle using the formula found in:
     * https://www.easycalculation.com/analytical/learn-triangle-incenter.php
     */
    public double[] incenter()
    {
        final double[] COORDINATES = new double[2];

        COORDINATES[0] = (sideLength(POINT1,POINT2) * POINT3[0]
                + sideLength(POINT1,POINT3) * POINT2[0]
                + sideLength(POINT2,POINT3) * POINT1[0]) / perimeter();
        COORDINATES[1] = (sideLength(POINT1,POINT2) * POINT3[1]
                + sideLength(POINT1,POINT3) * POINT2[1]
                + sideLength(POINT2,POINT3) * POINT1[1]) / perimeter();

        return COORDINATES;
    }


    /*
     * Finds the centroid of the Triangle using the formula in:
     * http://www.mathopenref.com/coordcentroid.html
     */
    public double[] centroid()
    {
        final double[] COORDINATES = new double[2];

        COORDINATES[0] = (POINT1[0] + POINT2[0] + POINT3[0]) / 3.0; // Find the
        COORDINATES[1] = (POINT1[1] + POINT2[1] + POINT3[1]) / 3.0; // average

        return COORDINATES;
    }


    /*
     * Centers the triangle via moving the centroid to the origin. Use at own
     * risk, this action cannot be undone.
     */
    public void center()
    {
        final double X_OFFSET = -centroid()[0];
        final double Y_OFFSET = -centroid()[1];

        move(POINT1, X_OFFSET, Y_OFFSET);
        move(POINT2, X_OFFSET, Y_OFFSET);
        move(POINT3, X_OFFSET, Y_OFFSET);
    }
}