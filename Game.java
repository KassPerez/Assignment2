import java.util.Scanner;

public class Game 
{
	private boolean testingMode;
	
	public Game(boolean testingMode)
	{
		this.testingMode = testingMode;
	}
	
	public void runGame()
	{
		boolean continuePlaying = false;
		do{
			Game_Functions.startMessage();
			if(testingMode == true)
			{
				continuePlaying = runTestingMode();
				if(continuePlaying == true)
				{
					continuePlaying = Game_Functions.contPlaying();
				}
			}
			else
			{
				continuePlaying = runNormGame();
				if(continuePlaying == true)
				{
					continuePlaying = Game_Functions.contPlaying();
				}
			}
		}while(continuePlaying == true);
		
	}
	
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
						System.out.println(Game_Functions.Answer[0] + Game_Functions.Answer[1] + Game_Functions.Answer[2]+ Game_Functions.Answer[3]);
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
