/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 7
*
*
*/

import java.util.Scanner;

public class Prob7{
	
	public static void main(String args[]){
				
		Scanner input = new Scanner(System.in);						//Declare scanner
		
		int T = input.nextInt();									//Get number of test cases
		int[] days=new int[T]; 										//Declare arrays for variables of time
		int[] hours=new int[T];
		int[] minutes=new int[T];
		int[] seconds=new int[T];

		for(int i=0;i<T;i++){										//Input
			days[i]= input.nextInt();
			hours[i]= input.nextInt();
			minutes[i]= input.nextInt();
			seconds[i]= input.nextInt();
		}

		for(int i=0;i<T;i++){										//Output and Method Call
			System.out.print("Case #"+(i+1)+": ");
			convert(days[i], hours[i], minutes[i], seconds[i]);
		}		
		
	}
	
	public static void convert(int d,int h,int m,int s){			//This is the convert method to simplify the times
			int temp;												//Create a temporary variable to hold carry values
			if (s>=60){												//Check if time value is greater than or equal to its max value
				temp = s/60;										//Give the temp variable the amount to carry over to the next time variable
				m=m+temp;											//The next time variable will now have an add value of the carry
				s=s%60;												//The time value will now only have the remainder as its value
			}
			if (m>=60){
				temp = m/60;
				h=h+temp;
				m=m%60;
			}
			if (h>=24){
				temp = h/24;
				d=d+temp;
				h=h%24;
			}
			
			System.out.print(d+" Days ");							//Print and checks if value is 0. If time value is 0 dont print it.
			if(h>0){
				System.out.print(h+" Hours ");
			}
			if(m>0){
			System.out.print(m+" Minutes ");
			}
			if(s>0){
			System.out.print(s+" Seconds");
			}
			System.out.println();
		}
}