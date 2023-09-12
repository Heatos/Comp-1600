/* This class contains a static method takes the users input of a date in the american format then it does julian
 * calendar calculation to find out what the julian day is, the day of the week, and what phase the moon is in
 * Author:      Zac Stray
 * Course:      Comp 1600
 * Assignment:  Project 2
 * Date:        9/15/2021
 */

import java.util.Scanner;

public class MoonPhase
{
    public static void main(String[] args)
    {
        //gets the month day and year from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the date (e.g. July 4, 1776): ");
        String month = in.next();
        String dayString = in.next();
        int year = in.nextInt();

        //creates the variable digits to know where to get the number of the date
        int digits;
        if(dayString.length() == 2)
            digits = 1;
        else
            digits = 2;

        int dayInt = Integer.parseInt(dayString.substring(0,digits));


        //finds the number of the month imputed
        int monthNumber;
        switch(month)
        {
            case "January":
                monthNumber = 1; break;
            case "February":
                monthNumber = 2; break;
            case "March":
                monthNumber = 3; break;
            case "April":
                monthNumber = 4; break;
            case "May":
                monthNumber = 5; break;
            case "June" :
                monthNumber = 6; break;
            case "July":
                monthNumber = 7; break;
            case "August":
                monthNumber = 8; break;
            case "September":
                monthNumber = 9; break;
            case "October":
                monthNumber = 10; break;
            case "November":
                monthNumber = 11; break;
            default:
                monthNumber = 12; break;
        }


        //does math the convert the date to Julian day calendar date

        int monthOffset = (14 - monthNumber)/12;
        int yearOffset = year + 4800 - monthOffset;
        int monthOffSet2 = monthNumber + 12 * monthOffset - 3;
        int julian = (dayInt + (153 * monthOffSet2 + 2)/5 + 365 * yearOffset + yearOffset/4 -
                yearOffset/100 + yearOffset/400 - 32045);

        int moonPhasePoint = 2415021;           //this number is January 1, 1900. in the julian calendar, using as a reference
        int weekDayNumber = (julian + 1) % 7;   //point for the moon phases calculations

        String dayWeek;
        switch(weekDayNumber)
        {
            case 0:
                dayWeek = "Sunday"; break;
            case 1:
                dayWeek = "Monday"; break;
            case 2:
                dayWeek = "Tuesday"; break;
            case 3:
                dayWeek = "Wednesday"; break;
            case 4:
                dayWeek = "Thursday"; break;
            case 5:
                dayWeek = "Friday"; break;
            default:
                dayWeek = "Saturday"; break;
        }


        int moonPhaseNum  = (int)Math.round((julian - moonPhasePoint) % 29.530588853/29.530588853 * 8);

        if(moonPhaseNum < 0)
            moonPhaseNum += 8;

        String moonPhase;
        switch (moonPhaseNum)
        {
            case 0: case 8:
                moonPhase = "New Moon"; break;
            case 1:
                moonPhase = "Waxing Crescent"; break;
            case 2:
                moonPhase = "First Quarter"; break;
            case 3:
                moonPhase = "Waxing Gibbous"; break;
            case 4:
                moonPhase = "Full Moon"; break;
            case 5:
                moonPhase = "Waning Gibbous"; break;
            case 6:
                moonPhase = "Last Quarter"; break;
            default:
                moonPhase = "Waning Crescent"; break;
        }

        System.out.format("%s %s %d has a Julian day of %d.\n", month, dayString, year, julian);
        System.out.println("Its day of the week is " + dayWeek + ".");
        System.out.println("Its phase of the moon is " + moonPhase + ".");
    }
}
