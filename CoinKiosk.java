//Jayden Cooper 

import java.util.Scanner; 

public class CoinKiosk
{

	public static void main(String[] args)
	{
		int pennies;
		int nickels;
		int dimes; 
		int quarters;
		int halfDollars;
		int silverDollars;
		
		Scanner getData = new Scanner(System.in);
		
		System.out.println("Hello there!! I am CoinKiosk and I will count your change for you... just enter your coin information below...");
		
		
		System.out.println("Number of Silver Dollars: ");
		silverDollars = getData.nextInt();
		
		System.out.println("Number of Half Dollars: ");
		halfDollars = getData.nextInt();
		
		System.out.println("Number of Quarters: ");
		quarters = getData.nextInt();
		
		System.out.println("Number of Dimes: ");
		dimes = getData.nextInt();
		
		System.out.println("Number of Nickels: ");
		nickels = getData.nextInt();
		
		System.out.println("Number of Pennies: ");
		pennies = getData.nextInt();
		
		int totalMoneyValue = (silverDollars * 100) + (halfDollars * 50) + (quarters * 25) + (dimes * 10) + (nickels * 5) + (pennies * 1);
		
		int totalDollars = totalMoneyValue / 100;
		int totalCents = totalMoneyValue % 100;
		
		System.out.println("... ... preparing your receipt ... ...");
		
		System.out.println("Your Total is: " +  totalDollars + " dollars" + " and " + totalCents + " cents.");

		System.out.println("**Take this receipt to a cashier to redeem your CoinKiosk amount");
	}

}


