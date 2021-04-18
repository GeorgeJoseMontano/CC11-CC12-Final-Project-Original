/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 2
*
*
*/

import java.util.Scanner;

public class Prob2{
	
    public static void main(String args[])
    {

        Scanner input=new Scanner(System.in);							//Declare scanner
        
		int T = input.nextInt();										//Get the number of test cases
		
		String[] num1=new String[T]; 									//Declaration of variable for 1st Name
		String[] num2=new String[T];									//Declaration of variable for 2nd Name
		
		for(int i=0;i<T;i++){											//Input
			num1[i]=input.next();
			num2[i]=input.next();
		}
		
		for(int i=0;i<T;i++){											//Output
			System.out.print("Case #"+(i+1)+": ");
			cancel(num1[i],num2[i]);									//Call Method
		}			
	}

    public static void cancel(String n1,String n2) 						//This is the Cancel Method
    {
     int total=n1.length()+n2.length();									//Add the total length for both names
     int canc=0,cases,temp;
     for(int i=0;i<n1.length();i++) 									//Using each letter of the 1st name
     {
         for(int j=0;j<n2.length();j++)									//Find in second name
         {
             if(n1.charAt(i)==n2.charAt(j)) 							//If letter in name1 = name 2 we cut
             {
                 ++canc; 											 	//Add to how many will be removed from total
                 n2=n2.substring(0,j)+n2.substring(j+1,n2.length()); 	//Removes letter using substring.
                 break;
                }
            }
        }
        int tocut=total-(canc*2); 										//Total will be equal to how many letters x2 because there are 2 names
		
	String f="FLAMES"; 													//Declare the string FLAMES
			
			while(f.length()!=1)										//Loop until there is only 1 letter left
			{
				int cut=0;
				for(int k=1;k<=tocut;k++)								//Determine the position of the letter to remove by looping cut
				{
					if(cut>=f.length())									//If the value of cut is greater than the length of letters left in flames we give it a value of zero because we put it in substring
					cut=0;				
					
					++cut;
					 
				}
				f=f.substring(0,cut-1)+f.substring(cut); 				//Using substring we remove letter where cut ends
				f=f.trim(); 											//Removes trailing spaces
			   
			}
		  
		  switch(f){													//Find out what the result when only one letter left
			  case "F":
			  System.out.println(" Friends");
			  break;
			  
			  case "L":
			  System.out.println(" Lovers");
			  break;
			  
			  case "A":
			  System.out.println(" Acquaintance");
			  break;
			  
			  case "M":
			  System.out.println(" Married");
			  break;
			  
			  case "E":
			  System.out.println(" Enemies");
			  break;
			  
			  case "S":
			  System.out.println(" Sweethearts");
			  break;
		}
    }
}