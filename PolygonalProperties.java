import java.util.Scanner;

public class PolygonalProperties
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);   //makes a scanner to get user input

        //asks user for first, last name, the number of sides, the length of the sides, the cost per square meter and
        //the cost per meter of fence
        //then saves them in appropriate variables

        System.out.print("Welcome to the Polygonal Property Calculator!\n\nEnter your first name:\t\t\t\t\t");
        String firstName = in.next();

        System.out.print("Enter your last name:\t\t\t\t\t");
        String lastName = in.next();
        System.out.print("Enter the sides the property has:\t\t");
        int sideNumber = in.nextInt(); //in meters
        System.out.print("Enter side length in meters:\t\t\t");
        double sideLength = in.nextDouble(); //in meters
        System.out.print("Enter property cost per square meter:\t$");
        double costPerSqr = in.nextDouble();
        System.out.print("Enter fence cost per meter:\t\t\t\t$");
        double fencePerMeter = in.nextDouble();



        double apothem = sideLength * 1/Math.tan(Math.PI/sideNumber) * .5;              //uses a variation of the formula 1/2 length * cot(180/sides) to find the apothem
        double  = sideNumber * length * apothem * .5;                                   //uses a variation of the formula 1/2 sides * length * apothem to find the area of the polygon
        double costLand = area * costPerSqr;                                            //use the formula of area * cost per meter square to find the cost of the land
        double primeter = sideNumber * sideLength;                                      //finds the perimeter of the property
        double intAngle = (Math.PI * (sideNumber - 2))/(double)(sideNumber);            //finds the interior angle of the property
        double fenceCost = primeter * fencePerMeter;                                    //finds the cost of the fencing on the property
        double landCost = area *
        double totalCost = fenceCost + findCostLand(length, sideNumber, costPerSqr);    //finds the cost of the fence and property combined


        //print out the desired information about the property


        System.out.format("\nProperty Information for %.1s. %s \n", firstName, lastName);
        System.out.println("****************************************************************");
        System.out.format("Total area:\t\t\t\t\t\t\t\t%.3f square meters\n", area);
        System.out.format("Total perimeter:\t\t\t\t\t\t%.3f meters\n", primeter);
        System.out.format("Length of apothem:\t\t\t\t\t\t%.3f meters\n",apothem);
        System.out.format("Interior angle:\t\t\t\t\t\t\t%.3f degrees\n", intAngle);
        System.out.format("Cost of land:\t\t\t\t\t\t\t$%.2f\n", findCostLand(sideLength, sideNumber, costPerSqr));
        System.out.format("Cost of fencing:\t\t\t\t\t\t$%.2f\n", fenceCost);
        System.out.format("Total cost:\t\t\t\t\t\t\t\t$%.2f\n", ftotalCost);


        System.out.println("\nLoan Information\n****************************************************************");

        //asks the user for the interest rate and how many years they have had a loan on the property
        System.out.print("Enter annual interest rate:\t\t\t\t");
        double interestRate = in.nextDouble();
        System.out.print("Enter length of loan in years:\t\t\t");
        int loanYears = in.nextInt();

        double currentCost = totalCost * Math.pow(1+interestRate,loanYears);

            //finally, prints out the cost of the property after sometime and interest rate
        System.out.format("Total cost with interest\t\t\t\t$%.2f\n", currentCost);

    }



    //uses the formula cost = (initial amount) * (1 + rate)to the power of years to find the cost over the years
    public static double findCurrentCost(double length, int sideNumber, double fencePerMeter, double costPerSqr, double interestRate, int loanYears)
    {
        return findTotalCost(length, sideNumber, fencePerMeter, costPerSqr) * Math.pow(1 + interestRate,loanYears);
    }
}