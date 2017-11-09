/*==============================================================================
|   Source code:    Histogram.java
|   Class:          Histogram
|
|   Author:     Luis Vitier
|   Student ID: 5723008
|   Assignment: Program #5 - Sequence of Primes
|  
|   Course:     COP 3337 (Intermediate Programming)
|   Section:    U09
|   Instructor: William Feild  
|   Due Date:   9 November 2017, by the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:  Java
|   Compile/Run: 
| 	javac SequenceDemo.java Sequence.java PrimeSequence.java Histogram.java
|	java SequenceDemo
|
|   Purpose:        Writing a single Histogram method became painful.
|
|   Inherits From:  None
|
|   Interfaces:     None
|
+-------------------------------------------------------------------------------
|
|   Constants:      No class constants
|
+-------------------------------------------------------------------------------
|
|   Constructors:       Constructor Histogram() takes two ints and an int array.
|
|   Class Methods:      No static class methods.
|
|   Instance Methods:   String toString() takes no arguments.
|
*=============================================================================*/

public class Histogram
{
    private int data[] = null;
    private int occurrences[] = null;
    private int scale = 1;

    /**
     * This is the constructor for the histogram class
     *
     * @param min       The smallest value in the histogram range.
     * @param max       The largest value in the histogram range.
     * @param data      The data being... histogramed!
     */
    public Histogram(int min, int max, int data[])
    {
        this.data = data;
        this.occurrences = new int[max - min];

        for(int i = min; i < max; i++)
        {
            occurrences[i] = count(data, i);
        }

        scale();
    }


    /**
     * This method finds the occurrence of a number as the last digit in an
     * array of ints.
     *
     * @param primes        The array of ints.
     * @param digit         The number we are looking for
     * @return              The occurence of the number.
     */
    private int count(int[] primes, int digit)
    {
        int count = 0;

        for (int prime : primes)
        {
            String asString = Integer.toString(prime);
            asString = asString.substring(asString.length() - 1);

            if (Integer.parseInt(asString) == digit)
            {
                count++;
            }
        }

        return count;
    }


    /**
     * This method returns the totak number of primes.
     *
     * @return      The total number of primes.
     */
    private int totalCount()
    {
        return data.length;
    }


    /**
     * This method determines the scale for the histogram.
     */
    private void scale()
    {
        int largest = 0;

        for (int i = 0; i < occurrences.length; i++)
        {
            if (occurrences[i] > largest)
            {
                largest = occurrences[i];
            }
        }

        scale = (int) Math.round(((double) largest / 20.0) + 0.5);
    }


    /**
     * This is the Histogram implementation of the toString() method.
     * @return      The histogram
     */
    @Override
    public String toString()
    {
        String str = "";
        int scaled = 0;
        for (int i = 0; i < occurrences.length; i++) {
            scaled = (int) ((double)occurrences[i] / (double) scale);
            if (occurrences[i] > 0 && scaled == 0)
            {
                scaled = 1;
            }
            str += "[" + i + "]";
            for (int j = 0; j < 20; j++) {
                if(scaled > j)
                {
                    str += "*";
                }
                else
                {
                    str += " ";
                }
            } //end loop
            str += "(" + occurrences[i] + ","
                    + ((int)(((double) occurrences[i] / totalCount()) * 100.0))
                    + "%)\n";
        } //end loop
        str += "scaled as %, * = " + scale + "%\n";
        return str;
    }
}