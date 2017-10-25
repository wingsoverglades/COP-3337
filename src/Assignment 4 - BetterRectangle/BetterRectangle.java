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
}