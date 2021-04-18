/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 6
*
*
*/

import java.util.Scanner;

public class Prob6{	

	public static void main(String args[]){
		Scanner input= new Scanner(System.in);						//Declare scanner
		int cases,temp;
		
		
		int T = input.nextInt();									//Get number of test cases
		
		String[] num=new String[T];									//Declare an array that will hold a string value

		
		for(int i=0;i<T;i++){										//Input
			num[i]=input.next();
		}

		for(int i=0;i<T;i++){										//Output and Method Call
			System.out.print("Case #"+(i+1)+": ");
			valid(num[i]);
		}
		
		
	}
		
	public static void valid(String str){
		boolean check = false;										//Declare a boolean variable and set it to false as default
            
 
        for(int i = 0; i < str.length(); i++) {						//Create a loop to check each character of the string
            if ((Character.isLetter(str.charAt(i)) == true)) {		//Check if character is a letter
				check = true;
			}

			if(str.charAt(i)=='#'){									//Check if character is a #
				check = true;
			}
			
			if(str.charAt(i)=='_'){									//Check if character is a _
				check = true;
			}
			
			if ((Character.isDigit(str.charAt(i)) == true)) {		//Check if character is an even number
				if(str.charAt(i)%2==0){
					check = true;
				}
				else{
					check = false;
					i=str.length()+1;								//End loop
				}
			}				
        }
		
		if ( Character.isDigit(str.charAt(0)) ){					//Check if first character is a number
				check = false;
			}
        if (str.length()>20){										//Check if string length is less than or equal to 20
				check = false;
			}
		if(check==true){											//Outputs depending on the boolean value
			System.out.println(" VALID");
		}
		if(check==false){
			System.out.println(" NOT VALID");
		}    
	}
}
