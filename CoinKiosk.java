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
		
		System.out.println("Hello there!!  I am CoinKiosk and I will count your change for you... just enter your coin information below...");
		
		
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








/*Amanda DelliColli to Everyone (4:11 PM)
import java.util.Scanner;
public class WalthamGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final double tax = .0625;
		int NumGame; 
		double discount;
		double calc1;
		double calc2;
		double calc3;
		
		Scanner getData =new Scanner (System.in);
		System.out.println("Enter number of games ordered by clients:");
		NumGame = getData.nextInt();
		
		calc1 = NumGame * 60;
		
		if(NumGame <= 9 )	
			{discount = 0;}	
		else if (NumGame <= 19)
			{discount = .20;}	
		else if (NumGame <= 49)
			{discount = .3;}
		else if (NumGame <= 99)
			{discount = .4;}
		else
			{discount  = .5;}
			
		calc2 = calc1 -(calc1 *discount);
		calc3 = calc2 + (calc2 * tax);
		
		System.out.println("Subtotal: $" + calc1);
		
		System.out.println("Qualified Discount: " + discount* 100 + " %");

		System.out.println("Subtotal with discount applied: $" + calc2 );
	
		System.out.println("Order Total with Tax: $" + calc3 );
			
		getData.close();
		
		//curly braces indicate actions not indent */
