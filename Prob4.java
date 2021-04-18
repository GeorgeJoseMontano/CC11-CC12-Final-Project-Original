/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 4
*
*
*/

import java.util.Scanner;

public class Prob4{
	
	public static void main(String args[])
    {
		Scanner input= new Scanner(System.in);
		
		int T = input.nextInt();									//Get number of test cases
		
		String[] num1=new String[T];								//Declaration of variable for 1st Number as string
		String[] num2=new String[T];								//Declaration of variable for 2nd Number as string
		
		for(int i=0;i<T;i++){										//Input
			num1[i]=input.next();
			num2[i]=input.next();
		}

		for(int i=0;i<T;i++){										//Output
			System.out.print("Case #"+(i+1)+": ");
			addLargeNum(num1[i],num2[i]);							//Call Method
		}
	}
	
	public static void addLargeNum(String num1, String num2){		//This is the addLargeNum Method that adds the two strings

		int max=0, min=0;											//Declaration of max and min and checks which string has the greater length to use as
																	// length for sum
		if(num1.length() > num2.length()){
			max = num1.length();
			min = num2.length();
			
		}
		if(num1.length() < num2.length()){
			max = num2.length();
			min = num1.length();
		}
		else{
			max = num1.length();
			
		}
			
		
		int n1[] = new int[max];									//Declaration of array for both numbers
		int n2[] = new int[max];
		
		
		
		for(int i=0;i<num1.length();i++){							//Input each digit of the numbers in their respective array from the last digit
			n1[i]=num1.charAt(num1.length()-1-i)-48;
		}
		
		for(int i=0;i<num2.length();i++){
			n2[i]=num2.charAt(num2.length()-1-i)-48;
		}
		

		int carry = 0;												//Declaration of the variable carry
		int sum[] = new int[max+1];									//Declaration of new array sum 
		
		for(int i=0;i<max;i++){
			sum[i] = (n1[i]+n2[i]+carry)%10;						//Add the two numbers in array. By getting only remainder we get only digits less than 9 
			if((n1[i]+n2[i]+carry)>=10)								//Check if there is a carry for the next sum
				carry = 1;
			else
				carry = 0;
		}

		sum[max]=carry;												//Give the last value as the carry of either 1 or 0
		
		if(sum[max]==1){											//Print in reverse. The if-else is to remove any 0 in front of the sum
			for(int j=max;j>=0;j--){								
			System.out.printf("%d",sum[j]);
			}
		}
		else{
			for(int j=max-1;j>=0;j--){
				System.out.printf("%d",sum[j]);
			}
		}
		System.out.println(" "); 
		
	}
    
}