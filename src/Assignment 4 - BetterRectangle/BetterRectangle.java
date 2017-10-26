/*==============================================================================
|   Source code:    BetterRectangle.java
|   Class:          BetterRectangle
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #4 - Better Rectangle
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   26 October 2017, by the begging of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac BetterRectangle.java
|	java
|
|   Purpose:    This program exists to solve some of the issues with the
|               original rectangle class.
|
|   Inherits From:  This class inherits from the Rectangle class.
|
|   Interfaces:  None
|
+-------------------------------------------------------------------------------
|
|   Constants:  No public constants
|
+-------------------------------------------------------------------------------
|
|   Constructors:   BetterRectangle() takes no arguments, BetterRectangle()
|                   takes two int arguments, BetterRectangle() takes four int
|                   arguments and BetterRectangle() takes another
|                   BetterRectangle object.
|
|   Class Methods:  No private class methods
|
|   Instance Methods:
|                   boolean equals() takes one BetterRectangle object, String
|                   toString() takes no arguments, int getArea() takes no
|                   arguments, int getPerimeter() takes no arguments, double
|                   getSlope() takes no arguments, Point getMidpoint() takes no
|                   arguments, boolean congruent() takes one BetterRectangle
|                   argument, boolean equivalent() takes one BetterRectangle
|                   object, boolean similar() takes one BetterRectangle
|                   argument, boolean concentric() takes one Better rectangle
|                   argument, boolean scaleBy() takes one int argument.
|
*=============================================================================*/

import java.awt.*;  //Dependency for the Rectangle class.

public class BetterRectangle extends Rectangle
{
    /**
     * Basic constructor for the BetterRectangle class, takes no arguments.
     */
    BetterRectangle()
    {
        super.setLocation(0,0);
        super.setSize(1,1);
    }

    /**
     * A more involved constructor for the BetterRectangle class. Takes two
     * arguments.
     * @param w     The width of the rectangle.
     * @param h     The height of the rectangle.
     */
    BetterRectangle(int w, int h)
    {
        super.setLocation(0,0);
        super.setSize(w, h);
    }

    /**
     * Most complete constructor for the BetterRectangle class. Takes four
     * arguments.
     * @param x     X coordinate for the rectangle.
     * @param y     Y coordinate for the rectangle.
     * @param w     The width of the rectangle.
     * @param h     The height of the rectangle.
     */
    BetterRectangle(int x, int y, int w, int h)
    {
        super.setLocation(x, y);
        super.setSize(w,h);
    }

    /**
     * Constructor for making a copy of another BetterRectangle object.
     * @param r     An already preexisting BetterRectangle object.
     */
    BetterRectangle(BetterRectangle r)
    {
        setLocation((int) r.getX(), (int) r.getY());
        setSize((int) r.getWidth(), (int) r.getHeight());
    }

    /**
     * This method implements an equals method for the BetterRectangle class
     * and determines if another rectangle has the same values as this.
     *
     * @param r     The other rectangle being compared.
     * @return      True if the rectangles are the same.
     */
    public boolean equals(BetterRectangle r)
    {
        return this.congruent(r) && this.concentric(r);
    }

    /**
     * This method overrides the toString method in the super class and
     * replaces it with its own toString that returns the relevant information.
     *
     * @return      A String containing the area, perimeter, slope, midpoint,
     *              anchor point, width and height of the rectangle.
     */
    public @Override String toString()
    {
        return "Area: " + getArea() + "\nPerimeter: " + getPerimeter()
                + "\nSlope: " + getSlope() + "\nMidpoint: " + getMidpoint()
                + "\nAnchor: (" + getX() + "," + getY() + ")"
                + "\nWidth: " + getWidth() + "\nHeight: " + getHeight();
    }

    /**
     * This method finds and returns the area of the rectangle.
     *
     * @return      The area of the rectangle.
     */
    public int getArea()
    {
        return (int)(getWidth() * getHeight());
    }

    /**
     * This method finds and returns the perimeter of the rectangle.
     *
     * @return      The perimeter of the rectangle.
     */
    public int getPerimeter()
    {
        return (int)((getWidth() * 2.0) + (getHeight() * 2.0));
    }

    /**
     * This method finds the slope of the opposite corners of the rectangle.
     *
     * @return      The slope of the rectangle.
     */
    public double getSlope()
    {
        return (getHeight() / getWidth());
    }

    /**
     *This method finds the midpoint of the rectangle and returns it in a Point.
     *
     * @return      A Point object containing the midpoint of the rectangle.
     */
    public Point getMidpoint()
    {
        final int X_COORD = (int)((getWidth() / 2.0) + getX());
        final int Y_COORD = (int)((getHeight() / 2.0) + getY());
        return new Point(X_COORD,Y_COORD);
    }

    /**
     * This method determines whether the two rectangles are congruent
     *
     * @param r     The rectangle being compared.
     * @return      True if the rectangles have the same width and height.
     */
    public boolean congruent(BetterRectangle r)
    {
        return this.getWidth() == r.getWidth()
                && this.getHeight() == r.getHeight();
    }

    /**
     * This method determines whether the two rectangles share the same
     * perimeter
     *
     * @param r     The rectangle being compared.
     * @return      True if the two rectangles share the same perimeter.
     */
    public boolean equivalent(BetterRectangle r)
    {
        return this.getPerimeter() == r.getPerimeter();
    }

    /**
     * THis method determines if the two rectangles have the same area.
     *
     * @param r     The rectangle that is being compared.
     * @return      True if the rectangles share the same area.
     */
    public boolean similar(BetterRectangle r)
    {
        return this.getArea() == r.getArea();
    }

    /**
     * This method determines whether or not the two rectangles have the same
     * midpoint.
     *
     * @param r     The rectangle that is being compared
     * @return      True if the two rectangle share a midpoint, false if they
     *              do not.
     */
    public boolean concentric(BetterRectangle r)
    {
        return this.getMidpoint().equals(r.getMidpoint());
    }

    /**
     * This method serves to increase or decrease the size of the rectangles
     * sides by a set scale
     *
     * @param scale     The scale by which the rectangle sides are multiplied.
     * @return          True if the the scale was a success, False if there
     *                  was a failure.
     */
    public boolean scaleBy(int scale)
    {
        try
        {
            this.setSize((int) (this.getX() * (double) scale),
                    (int) (this.getY() * (double) scale));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}