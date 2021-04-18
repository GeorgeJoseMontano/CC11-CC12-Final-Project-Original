/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 3
*
*
*/

import java.util.Scanner;

public class Prob3{
	
	public static void main(String args[]){	
		Scanner input = new Scanner(System.in);				//Declare scanner
		int T = input.nextInt();							//Get number of test cases
		
		int[]num1=new int[T];								//Declaration of variable for 1st Number
		int[]num2=new int[T];								//Declaration of variable for 2nd Number
		
		for(int i=0;i<T; i++){								//Input
			num1[i]=input.nextInt();
			num2[i]=input.nextInt();
		}
		for(int i=0;i<T; i++){								//Output
			System.out.print("Case#"+(i+1)+": ");
			if (carry(num1[i],num2[i])==0){					//If there is 0 carry operations, print No instead of 0
				System.out.print("No");
			}
			else{
				System.out.print(carry(num1[i],num2[i]));
			}
			System.out.println(" carry operations.");
		}
	}

	
	public static int carry(int a, int b)					//This is the Carry Method that checks for number of carry operations
	{
		if(a == 0 && b == 0) {								//If both numbers are 0 then there are no carry operations
			return 0;
		}
		else if((a%10) + (b%10) > 9) {						//If the sum of the remainders of both numbers is greater than 9 we have a carry operation
			return 1 + carry(a/10, b/10);					//then we check for more carry operations on the next decimal places using recursion.
		}
		else {
			return carry(a/10, b/10);						//If the sum of the remainders of both numbers is less than 9 we dont have a carry operation
		}													//then we check for more carry operations on the next decimal places using recursion.
	}

}