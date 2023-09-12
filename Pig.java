/* This class contains a static method does the game pig as Human vs Human, Human vs Comp, or Comp vs Comp
 *
 * Author:      Zac Stray
 * Course:      Comp 1600
 * Assignment:  Project 4
 * Date:        10/25/2021
 */

import java.util.Scanner;

public class Pig
{

    public static void main(String[] args)
    {
        //asks the user what game type they would like to play
        Scanner in = new Scanner(System.in);
        System.out.println("The Game of Pig");
        System.out.println("--------------------------------------");
        System.out.println("1. Human vs. Human");
        System.out.println("2. Human vs. Computer");
        System.out.println("3. Computer vs. Computer");
        System.out.print("\nWhat kind of game do you want to play? ");
        int choice = in.nextInt();
        boolean player1;
        boolean player2;

        //finds if the player is a comp or human true if human false if computer
        switch (choice)
        {
            case 1:
                player1 = true; player2 = true; break;
            case 2:
                player1 = true; player2 = false; break;
            default:
                player1 = false; player2 = false; break;
        }
        playGame(player1, player2);
    }

    public static void playGame( boolean player1, boolean player2 )
    {
        int player1TotalScore = 0;
        int player2TotalScore = 0;

        boolean playerTurn = true; //playerTurn keeps track of who's turn it is


        //keeps going until one of the players gets over 100
        while(player1TotalScore < 100 && player2TotalScore < 100)
        {
            System.out.println();
            System.out.println("Player 1 Score: " + player1TotalScore);
            System.out.println("Player 2 Score: " + player2TotalScore);
            System.out.println();

            if(playerTurn)
            {
                player1TotalScore += playTurn(player1, 1, player1TotalScore);
                playerTurn = false;
            }
            else
            {
                player2TotalScore += playTurn(player2, 2, player2TotalScore);
                playerTurn = true;
            }

        }
        System.out.println("Player's 1 Score: " + player1TotalScore);
        System.out.println("Player's 2 Score: " + player2TotalScore);
        System.out.println();

        if(player1TotalScore > player2TotalScore)
            System.out.println("Player 1 Wins!");
        else
            System.out.println("Player 2 Wins!");
    }

    public static int playTurn( boolean player, int number, int totalScore )
    {
        int roll;
        //figures out if the player is a human or player
        String playerName;
        int turnScore = 0;
        if(player)
            playerName = "Human";
        else
            playerName = "Computer";


        System.out.println("Player " + number + "'s Turn (" + playerName + ")");
        do
        {
            roll = (int)Math.round(Math.random()*6) + 1;
            System.out.println("Rolled a " + roll);
            turnScore += roll;
            System.out.println("Turn Score: " + turnScore);
        } while (roll > 1 && getDecision(player, turnScore, totalScore));

        //you lose all the points if you roll a 1
        if(roll == 1)
            turnScore = 0;
        System.out.println("Turn Over\n");
        return turnScore;
    }

    public static boolean getDecision( boolean player, int turnScore, int totalScore )
    {
        Scanner in = new Scanner(System.in);
        if(player)
        {
            System.out.print("Hold or Roll? (h or r) ");
            String decision = in.next();
            char decisionChar = decision.charAt(0);
            //figures out if the player wants to hold or roll
            if(decisionChar == 'h')
            {
                System.out.println("Human player holds");
                return false;
            }
            else
            {
                System.out.println("Human player rolls");
                return true;
            }
        }
        else
            //comp will keep rolling unless the turn roll is 20 or higher but will stop if they would win with their score
            if(turnScore > 20 || turnScore + totalScore >= 100)
            {
                System.out.println("Computer player holds");
                return false;
            }
            else
            {
                System.out.println("Computer player rolls");
                return true;
            }
    }
}
