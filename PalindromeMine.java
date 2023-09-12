import java.util.Scanner;

public class PalindromeMine
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = in.nextLine();
        String testingInput = "";
        boolean palindrome = true;

        //makes a string that is easier to work with but is the same as the input but all letters are lower case and
        //all spaces and punctuation is removed
        for(int i = 0; i < input.length(); i++)
        {
            if(Character.isLetter(input.charAt(i)))
            {
                testingInput += Character.toLowerCase(input.charAt(i));
            }
        }

        for(int i = 0; i < testingInput.length()*.5; i++)
        {
            if(testingInput.charAt(i) != testingInput.charAt(testingInput.length()- 1 - i ))
            {
                palindrome = false;
                i = testingInput.length();
            }
        }


        if(palindrome)
            System.out.println("Your phrase is a palindrome");
        else
            System.out.println("Your phrase is not a palindrome");
    }
}
