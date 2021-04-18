/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 5
*
*
*/

import java.util.Scanner;

public class Prob5{
	
	private static Scanner sc;
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);						//Declare scanner
		int R,r,c;
		int T = input.nextInt();									//Get number of test cases
		
		int[] zeta = new int[T];									//Declare an array that will hold value of methoud output for later

		for(int i=0;i<T;i++){										//Input
			//System.out.println("Enter Dimensions: ");
			R= input.nextInt();										//Input for matrix dimensions
			int[][] A = new int [R][R];								//Declare matrix
			for(r=0;r<R;r++){
				for(c=0;c<R;c++){
					A[r][c]=input.nextInt();						//Input for matrix elements
					if(A[r][c] != 1 && A[r][c] != 0){				//Check if input is either 1 or 0 Exit program if not 1 or 0
						System.out.print("Wrong Input!!!");
						System.exit(0);
					}
				}
			}
			zeta[i]=usb(A);											//Let zeta variable hold the output of the method
		}
		
		for(int i=0;i<T;i++){										//Output
			System.out.print("Case #"+(i+1)+": ");
			if(zeta[i]==0){											//Checks value returned by method to determine if OK or NOT OK
				System.out.println("OK");
			}
			else{
				System.out.println("NOT OK");
			}
		}		
	}
		
		
		public static int usb(int[][] a){							//This is the usb method to check sum of rows and columns is even
		int rows,cols,sumRow,sumRol,r,c;							//Declare variables
		int count=0;	
			
			rows = a.length;										//Give variables the value of the length of the dimensions
			cols = a[0].length;
			
			for(r=0;r<rows;r++){									//Get the sum of rows
				sumRow = 0;
				for(c=0;c<cols;c++){
					sumRow=sumRow+a[r][c];
				}
				if(sumRow%2!=0){									//Check if sum of rows is even
					count++;
				}		
			}
			
			for(c=0;c<cols;c++){									//Get the sum of columns
				sumRol=0;
				for(r=0;r<rows;r++){
					sumRol=sumRol+a[r][c];
				}
				if(sumRol%2!=0){									//Check if sum of columns is even
					count++;
				}				
			}
			
			return count;
		}	
	
}