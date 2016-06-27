/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Lei Liu
 * LL28379
 * Kassandra Perez
 * KAP2589
 * https://github.com/KassPerez/Assignment2.git
 * Slip days used: <0>
 * Summer 2016
 */
import java.util.Scanner;

public class Game 
{
	private boolean testingMode;
	
	/*
	 * method that is called to make the game show the secret code
	 */
	public Game(boolean testingMode)
	{
		this.testingMode = testingMode;
	}
	/**
	 * method that runs the game when it is called
	 */
	public void runGame()
	{
		boolean continuePlaying = false;
		do{
			Game_Functions.startMessage();
			if(testingMode == true)					//a check to see if the answer needs to be shown
			{
				continuePlaying = runTestingMode();
				if(continuePlaying == true)
				{
					continuePlaying = Game_Functions.contPlaying();
				}
			}
			else									//the game will run normally if testing mode is not true
			{
				continuePlaying = runNormGame();
				if(continuePlaying == true)
				{
					continuePlaying = Game_Functions.contPlaying();
				}
			}
		}
		while(continuePlaying == true);
	}
	/**
	 * runs normal game 
	 * @return
	 */
	public boolean runNormGame()
	{
		System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N):");
		Scanner reader = new Scanner(System.in);
		String answer = reader.nextLine();
		int blackPegs=0;
		int whitePegs=0;
		
		while((!(answer.equals("Y"))) && (!(answer.equals("N"))))
		{
			System.out.println("---INVALID INPUT---");
			System.out.println("-Please input a Y for yes or a N for no-");
			System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N):");
			reader = new Scanner(System.in);
			answer = reader.nextLine();
		}
		
		if(answer.equals("Y")){
			Game_Functions.Generate();
			int num_Guesses=GameConfiguration.guessNumber;
			while(num_Guesses>=0){
				Game_Functions.next(num_Guesses);
				answer = reader.nextLine();
				if(answer.equals("history")){
					Game_Functions.History(GameConfiguration.guessNumber-num_Guesses);
				}
				else{
					if(Game_Functions.check_input(answer)==true){
						System.out.println("Your answer will be checked");
						blackPegs=Game_Functions.Pegs_Check(answer, GameConfiguration.guessNumber-num_Guesses);
						if(blackPegs==GameConfiguration.pegNumber){
							System.out.println(answer + " -> Result: " + GameConfiguration.pegNumber + " black pegs - You win!!");
							return true;
						}
						else{
							num_Guesses-=1;
							if(num_Guesses==0){
								System.out.println("Sorry, you have run out of attemps. GAME OVER!");
								return true;
							}
						}
					}
					else{
						System.out.println(answer + " -> INVALID GUESS");
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * method that runs the game in testing mode and shows the answer
	 * @return
	 */
	public boolean runTestingMode()
	{
		System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N):");
		Scanner reader = new Scanner(System.in);
		String answer = reader.nextLine();
		int blackPegs=0;
		int whitePegs=0;
		while((!(answer.equals("Y"))) && (!(answer.equals("N"))))
		{
			System.out.println("---INVALID INPUT---");
			System.out.println("-Please input a Y for yes or a N for no-");
			System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N):");
			reader = new Scanner(System.in);
			answer = reader.nextLine();
		}
		if(answer.equals("Y")){
			Game_Functions.Generate();
			int num_Guesses=GameConfiguration.guessNumber;
			while(num_Guesses>=0){
				Game_Functions.next(num_Guesses);
				answer = reader.nextLine();
				if(answer.equals("history")){
					Game_Functions.History(GameConfiguration.guessNumber-num_Guesses);
				}
				else{
					if(Game_Functions.check_input(answer)==true){
						System.out.println("Your answer will be check");
						for(int i=0; i<GameConfiguration.pegNumber; i+=1){
							System.out.print(Game_Functions.Answer[i]);
						}
						System.out.println();
						blackPegs=Game_Functions.Pegs_Check(answer, GameConfiguration.guessNumber-num_Guesses);
						if(blackPegs==GameConfiguration.pegNumber){
							System.out.println(answer + " -> Result: " + GameConfiguration.pegNumber + " black pegs - You win!!");
							return true;
						}
						else{
							num_Guesses-=1;
							if(num_Guesses==0){
								System.out.println("Sorry, you have run out of attemps. GAME OVER!");
								return true;
							}
						}
					}
					else{
						System.out.println(answer + " -> INVALID GUESS");
					}
				}
			}
		}
		return false;
		
	}
}
