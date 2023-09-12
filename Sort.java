import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


public class Sort
{

    public static void sort(int[] numbers)
    {
        int temp;
        for(int i = 0; i < numbers.length - 1; i++)
        {
            int lowest = i;

            for (int j = 1 + i; j < numbers.length; j++)//finds the smallest number's index in an array
            {
                if (numbers[lowest] > numbers[j])
                    lowest = j;
            }
            temp = numbers[i];
            numbers[i] = numbers[lowest];
            numbers[lowest] = temp;
        }

    }

    public static void main(String[] args)
    {
        int length;

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.print("How many values would you like to generate? ");
        length = in.nextInt();
        int[] original = new int[length];
        int[] numbers = new int[length];

        System.out.println("\nThe numbers are: ");

        for( int i = 0; i < numbers.length; i++ ) {
            original[i] = numbers[i] =  random.nextInt(1000); //generates numbers from 0 - 999
            System.out.print( numbers[i] + " ");
        }

        sort(numbers);

        System.out.println("\n\nThe numbers sorted are: ");

        for( int i = 0; i < numbers.length; i++ )
            System.out.print( numbers[i] + " ");

        System.out.println();

        Arrays.sort(original);

        boolean sorted = true;
        for( int i = 0; i < numbers.length && sorted; i++ )
            if( numbers[i] != original[i] )
                sorted = false;

        if( !sorted )
            System.out.println("Warning: Numbers are not sorted correctly!");
    }

}