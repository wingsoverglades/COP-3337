/*==============================================================================  
|   Source code:    SequenceDemo.java
|   Author:         Luis Vitier
|   Student ID:     5723008 
|   Assignment:     Program #5 Sequence of Primes
|  
|   Course:     COP 3337 (Programming 2)
|   Section:    U09 
|   Instructor: William Feild  
|   Due Date:   November 9, 2017, at the beginning of class
|
|	I hereby certify that this collective work is my own and none of it is the
|   work of any other person or entity.
|	______________________________________ [Signature]
|  
|   Language:       Java 8
|   Compile/Run:
| 	javac SequenceDemo.java Sequence.java PrimeSequence.java Histogram.java
|	java SequenceDemo
| 
+-------------------------------------------------------------------------------  
|  
|   Description:    Implement a Sequence interface to write program that
|                   provides a defined number of primes starting at a defined
                    point and give it fancy output.
|                  
|   Input:          Input will be provided on the command-line. Two input
|                   constants will be placed on the command-line upon execution.
|                   For example: java SequenceDemo 6 50; where the prime
|                   sequence will start with the next prime after the first
|                   number, and the second number (n) is the number of prime
|                   numbers to be sequenced. Both numbers will be integers and
|                   both numbers must be 1 or greater.
|  
|   Output:         Output will provide a table of n prime numbers. The table
|                   will be as close to “square” as possible - i.e. same number
|                   of rows and columns - with at most 10 entries per row. All
|                   entries will be right-aligned. Additionally, output will
|                   include a “histogram” of the occurrences of the last digit
|                   [0-9] of each prime number. The histogram will be horizontal
|                   and will be scaled (as a percentage %) if required, with a
|                   legend at the bottom to explain the scale and display the
|                   total count of primes.
|  
|   Process:        Formulated my own prime remainder method after reading
|                   about the Chinese remainder method and thinking it too
|                   hard to implement in full. I do not think I invented that
|                   process but I came up with it on my own.
|  
|   Required Features Not Included:  
|                   The numbers in the square are not right-hand aligned, I
|                   implemented the histogram as well as I understood it but I
|                   have a feeling I did it incorrectly.
|  
|   Known Bugs:     after the 150th prime number, the square is no longer...
|                   square.
*=============================================================================*/

public class SequenceDemo
{
    public static void main(String[] args)
    {
        validate(args);

        PrimeSequence primer = new PrimeSequence(Integer.parseInt(args[0]));
        int primes[] = new int[Integer.parseInt(args[1])];

        for(int i = 0; i < primes.length; i++)
        {
            primes[i] = primer.next();
        }

        System.out.println(makeSquare(primes));
        System.out.println(new Histogram(0,9,primes));
    }


    /**
     * Validates the commandline arguments passed to the programs and
     * determines whether or not they are valid. WILL exit the program if
     * valid input is not provided.
     *
     * @param args      The arguments passed to the commandline.
     */
    private static void validate(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Please supply the program with two integer " +
                    "arguments greater than 1");
            System.exit(1);
        }
        if (Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0)
        {
            System.out.println("Please only input integers greater than 1");
            System.exit(1);
        }
    }


    /**
     * This method takes an array of integers and makes them into a "square"
     *
     * @param primes        The array of primes.
     * @return              The String square.
     */
    private static String makeSquare(int[] primes)
    {
        int side = (int)Math.sqrt(primes.length);

        if (side > 10)  //max number of rows is 10
        {
            side = 10;
        }

        String square = "";

        for (int i = 0; i < primes.length; i++)
        {
            if ((i != 0) && (i % side == 0))
            {
                square = square + "\n";
            }

            square += primes[i] + "\t";
        }

        return square;
    }
}