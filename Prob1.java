/**
*Group Members: Apor, Hannah
*				Dagondon, Deanielle Mae
*				Montano, George Jose P.	
*
*Date: March 10, 2020
*
*Final Project Problem 1
*
*
*/

import java.util.Random;
import java.util.Scanner;  
 
public class Prob1{
   
	static boolean gameOver; //fields
	static int r_size, c_size;
    static int[][] minesfield;
    static char[][] outputField;
	/**
	*
	*/
    static void boardSize(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nWelcome to the game of Minesweeper!\nType the dimensions for the game\n> ");
        r_size = sc.nextInt();
		c_size = sc.nextInt();
		minesfield = new int[r_size][c_size];
		outputField = new char[r_size][c_size];
		System.out.println();
    }
    
	
	/**
	*@param mines 
	*@param output 
	*/
	static void board (int[][] mines, char[][] output){
        for (int r = 0; r < output.length; r++){
            for (int c = 0; c < output[0].length; c++){
               output[r][c] = '.';
			}
        }
         // generate a random mine field
        for (int r = 0; r <  mines.length; r++){
            for (int c = 0; c < mines[0].length; c++){
				mines[r][c] = (int)(Math.random() * 2);
			}
        }
    }  // init
    
   
    /**
	**@param output 
	*/
    static void displayOutput (char[][] output){
         for (int r = 0; r < output.length; r++){
            for (int c = 0; c < output[0].length; c++){
				System.out.print (" " + (char)output[r][c] + " ");
			}
            System.out.println();
         }
		System.out.println();		 
      }
    
    
    /**
	*@param mines
	*@param r
	*@param c
	*@return count The total number of mines
	*/
    static int countMines (int[][] mines, int r, int c){
        int rMin = r-1;
        int rMax = r+1;
        int cMin = c-1;
        int cMax = c+1;
        if (r == 0){
			rMin = 0;
		}if (r == mines.length-1){
			rMax = mines.length-1;
		}if (c == 0){ 
			cMin = 0;
		}if (c == mines.length-1){
			cMax = mines.length-1;
		}
        int count = 0;
        for(int i = rMin; i<= rMax; i++) { //rows
           for(int j = cMin; j<= cMax; j++)	{ //columns
            if(mines[i][j] == 1 && i != r && j !=c) {
                count++;
			}
          }
        }
        return count;
      }  // countMines
       
    /**
	*@param mines
	*/
    private static boolean checkStatus(int[][] mines){
        int count = 0;
        int target = mines.length*mines.length;//total area of grid
        for (int r = 0; r <mines.length; r++){
			for(int c = 0; c <mines.length;c++){
				if(mines[r][c]==1 || mines[r][c]==-1){//counts bombs
                count++;
				}
				if(count==target){//if count is equal to the area, the game is over because there are no more blank spaces
                return true;
				}
             }            
         }
         return false;//grid not complete
    }//checkStatus
               
    
   
    /**
	*@param mines
	*@param outputBoard
	*/
    static void playGame (int[][] mines, char[][] outputBoard) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter row and column of the cell you want to open \nrow [x] column [y]\n> ");
        int row = sc.nextInt();//row #
        int col = sc.nextInt();//column #
		
        if (mines[row][col] == 1){//if there is a bomb a that coordinate
			System.out.println("\nYou Lose");
			outputBoard[row][col]='*';
			gameOver = true;
        }else{
			outputBoard[row][col]=(countMines(mines,row,col)+"").charAt(0);//display number of bombs surrounding space
			mines[row][col]=-1;//mark space as used
				if (checkStatus(mines)==true){//The user wins
				System.out.println("\nCongratulations!");
				gameOver = true;
			}//game continues
        }
    } 
	
	
	public static void main (String[] args){
        boardSize();         
        board(minesfield, outputField);         
        displayOutput(outputField);
        do{
            playGame(minesfield, outputField);
            displayOutput(outputField);  
        }while (gameOver != true);
    }
}