/*==============================================================================  
|   Source code:    TriangleTester.java]
|   Author:         Luis Vitier
|   Student ID:     5723008 
|   Assignment:     Program #2 Triangle
|  
|   Course:     COP 3337 (Programming 2)
|   Section:    U09 
|   Instructor: William Feild  
|   Due Date:   Thursday, 28 September 2017 , at the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:       Java 8
|   Compile/Run:    javac Triangle.java TriangleTester.java
|                   java TriangleTester
| 
+-------------------------------------------------------------------------------  
|  
|   Description:    The program will prompt the user for three pairs of
|                   coordinates, Using that data, the program will then
|                   construct a Triangle using the three pairs of coordinates as
|                   points.
|                  
|   Input:          Program will prompt a user to provide x- and y-coordinates
|                   for the three Points of a triangle. A coordinate is a
|                   floating-point value and can be positive, negative or zero.
|  
|   Output:         Output will include the triangle name and all three Points,
|                   the lengths of all three sides, the three angles at the
|                   corners, the perimeter and the area of the triangle, and
|                   whether the triangle is Equilateral or Right-angled — all
|                   in a nicely formatted layout, as directed. Values displayed
|                   will be designated in the appropriate “units” and angles
|                   will be displayed in degrees (˚). All printed values will be
|                   rounded and formatted to four decimal-point accuracy,
|                   degrees rounded to the nearest degree.
|  
|   Process:        This program as a whole uses very basic Triangle formulas
|                   in order to get the desired results. The only 2
|                   algorithms of note are the "SAS" algorithm to find the area
|                   of the triangle and the "SSS" algorithm to find an angle.
|  
|   Required Features Not Included:  
|                   All required features present.
|  
|   Known Bugs:     No known bugs
*=============================================================================*/

import java.util.Scanner;   // Utility for getting user input

public class TriangleTester
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please input an x and y value for the first point, "
                + "the coordinates are floating point and can be positive, "
                + "negative or zero. Enter the values then press the [return]"
                + " key");
        System.out.print("x1: ");
        final double X1 = input.nextDouble();
        System.out.print("y1: ");
        final double Y1 = input.nextDouble();

        System.out.println("Please input an x and y value for the second "
                + "point");
        System.out.print("x2: ");
        final double X2 = input.nextDouble();
        System.out.print("y2: ");
        final double Y2 = input.nextDouble();

        System.out.println("Please input an x and y value for the third "
                + "point");
        System.out.print("x3: ");
        final double X3 = input.nextDouble();
        System.out.print("y3: ");
        final double Y3 = input.nextDouble();


        Triangle tri = new Triangle(X1,Y1, X2,Y2, X3,Y3);


        //Test for points
        System.out.printf("\nPoint1: (%.4f,%.4f",
                tri.getPOINT1()[0], tri.getPOINT1()[1]);
        System.out.printf("\nPoint2: (%.4f,%.4f",
                tri.getPOINT2()[0], tri.getPOINT2()[1]);
        System.out.printf("\nPoint3: (%.4f,%.4f\n",
                tri.getPOINT3()[0], tri.getPOINT3()[1]);

        //Test for side lenghts
        System.out.printf("Side 1 length: %.4f\n",
                Triangle.sideLength(tri.getPOINT1(),tri.getPOINT2()));
        System.out.printf("Side 2 length: %.4f\n",
                Triangle.sideLength(tri.getPOINT1(),tri.getPOINT3()));
        System.out.printf("Side 3 length: %.4f\n",
                Triangle.sideLength(tri.getPOINT2(),tri.getPOINT3()));

        //Test for angles
        System.out.println("Angle 1: "
                + (int) Math.round(tri.angle(tri.getPOINT1())) + "°");
        System.out.println("Angle 2: "
                + (int) Math.round(tri.angle(tri.getPOINT2())) + "°");
        System.out.println("Angle 3: "
                + (int) Math.round(tri.angle(tri.getPOINT3())) + "°");

        //Test for perimeter and area
        System.out.printf("Perimeter: %.4f\n", tri.perimeter());
        System.out.printf("Area: %.4f\n", tri.area());

        // Test for equilateral and rightness
        System.out.println("Is the triangle equilateral? "
                + tri.isEquilateral());
        System.out.println("Is the triangle a right triangle? "
                + tri.isRight());

        //Test for incenter and centroid
        System.out.printf("Coordiantes of the incenter: (%.4f,%.4f)\n",
                tri.incenter()[0], tri.incenter()[1]);
        System.out.printf("Coordinates of the centroid: (%.4f,%.4f)\n",
                tri.centroid()[0], tri.centroid()[1]);


        //Center the triangle and begin second test
        tri.center();
        System.out.println("\nThe triangle has been centered\n");


        //Test for points
        System.out.printf("\nPoint1: (%.4f,%.4f",
                tri.getPOINT1()[0], tri.getPOINT1()[1]);
        System.out.printf("\nPoint2: (%.4f,%.4f",
                tri.getPOINT2()[0], tri.getPOINT2()[1]);
        System.out.printf("\nPoint3: (%.4f,%.4f\n",
                tri.getPOINT3()[0], tri.getPOINT3()[1]);

        //Test for side lenghts
        System.out.printf("Side 1 length: %.4f\n",
                Triangle.sideLength(tri.getPOINT1(),tri.getPOINT2()));
        System.out.printf("Side 2 length: %.4f\n",
                Triangle.sideLength(tri.getPOINT1(),tri.getPOINT3()));
        System.out.printf("Side 3 length: %.4f\n",
                Triangle.sideLength(tri.getPOINT2(),tri.getPOINT3()));

        //Test for angles
        System.out.println("Angle 1: "
                + (int) Math.round(tri.angle(tri.getPOINT1())) + "°");
        System.out.println("Angle 2: "
                + (int) Math.round(tri.angle(tri.getPOINT2())) + "°");
        System.out.println("Angle 3: "
                + (int) Math.round(tri.angle(tri.getPOINT3())) + "°");

        //Test for perimeter and area
        System.out.printf("Perimeter: %.4f\n", tri.perimeter());
        System.out.printf("Area: %.4f\n", tri.area());

        // Test for equilateral and rightness
        System.out.println("Is the triangle equilateral? "
                + tri.isEquilateral());
        System.out.println("Is the triangle a right triangle? "
                + tri.isRight());

        //Test for incenter and centroid
        System.out.printf("Coordiantes of the incenter: (%.4f,%.4f)\n",
                tri.incenter()[0], tri.incenter()[1]);
        System.out.printf("Coordinates of the centroid: (%.4f,%.4f)\n",
                tri.centroid()[0], tri.centroid()[1]);
    }
}