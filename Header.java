package assignment2;

import java.util.Scanner;

/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * <Student 1 Name>
 * <Student 1 EID>
 * <Student 2 Name>
 * <Student 2 EID>
 * <Your GIT URL>
 * Slip days used: <0>
 * Summer 2016
 */

public class Header
{
	public static void main(String[] arg)
	{
		String answer;
		do{
			Game game = new Game(true);
			game.runGame();
			System.out.print("Are you ready for another game (Y/N):");
			Scanner reader = new Scanner(System.in);
			answer = reader.nextLine();
		}while(answer.equals("Y"));
		
	}
}
