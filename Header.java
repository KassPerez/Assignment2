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
public class Header{
	public static void main(String[] arg){
		System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N):");
		Scanner reader = new Scanner(System.in);
		String answer = reader.next();
		if(answer.equals("Y")){
			System.out.println("Generating secret code ....");
			int num_Guesses=GameConfiguration.guessNumber;
			while(num_Guesses>=0){
				GameConfiguration.next(num_Guesses);
				answer = reader.next();
				if(GameConfiguration.check_input(answer)==true){
					System.out.println("Your answer will be check");
				}
				else{
					System.out.println(answer + " -> INVALID GUESS");
				}
			}
		}
	}
}