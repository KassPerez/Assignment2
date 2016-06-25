import java.util.*;

public class Game_Functions {
	public static String[] Answer = new String[GameConfiguration.pegNumber];
	public static String[] History = new String[GameConfiguration.guessNumber];
	public static int[] Black_Peg_H = new int[GameConfiguration.guessNumber];
	public static int[] White_Peg_H = new int[GameConfiguration.guessNumber];
	
	public static void next(int Guesses){
		System.out.println("You have " + Guesses + " guesses left.");
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.print("Enter Guess:");
		return;
	}
	
	public static void startMessage()
	{
		System.out.print("Welcome to Mastermind. Here are the rules. \n\nThis is a text version of the classic board game Mastermind."
				+ "The computer will think of a secret code. The code consists of " + GameConfiguration.pegNumber 
				+ " colored pegs. \nThe pegs MUST be one of " + GameConfiguration.colors.length
				+ " colors: ");
		for(int i = 0;i < GameConfiguration.colors.length;i++)
		{
			System.out.print(GameConfiguration.colors[i]);
			if(i == GameConfiguration.colors.length - 1)
			{
				System.out.print(".");
			}
			else
				System.out.print(", ");
		}
		System.out.print("\nA color may appear more than once in the code. You try to guess what "
				+ "colored pegs are in the code and what order they are in. \nAfter you make a valid guess the result (feedback) will be displayed."
				+ "\nThe result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess. \nFor each peg in "
				+ "the guess that is the correct color, but is out of position, you get a white peg. For each peg that is fully incorrect,"
				+ " you get no feedback. \nOnly the first letter of the color is displayed. B for Blue, R for Red, and so forth. "
				+ "\nWhen entering guesses you only need to enter the first character of each color as a capital letter.\n\n");
	}
	
	public static boolean contPlaying()
	{
		System.out.print("Are you ready to for another game (Y/N):");
		Scanner reader = new Scanner(System.in);
		String answer = reader.nextLine();
		while((!(answer.equals("Y"))) && (!(answer.equals("N"))))
		{
			System.out.println("---INVALID INPUT---");
			System.out.println("-Please input a Y for yes or a N for no-");
			System.out.print("Are you ready to for another game (Y/N):");
			reader = new Scanner(System.in);
			answer = reader.nextLine();
		}
		
		return answer.equals("Y");
	}
	
	public static void Generate(){
		System.out.println("Generating secret code ....");
		Random randomGenerator = new Random();
		
		for(int i = 0; i < GameConfiguration.pegNumber; i++)
		{
			int randomInt = randomGenerator.nextInt(GameConfiguration.colors.length);
			Answer[i] = GameConfiguration.colors[randomInt];
		}
		
	}
	
	public static boolean check_input(String x){
		if(x.length() != GameConfiguration.pegNumber)
		{
			return false;
		}
		String strColors = String.join("", GameConfiguration.colors);
		for(int i = 0; i < x.length();i++)
		{
			boolean flag = false;
			for(int j = 0; j < strColors.length();j++)
			{
				if(x.charAt(i) == strColors.charAt(j))
				{
					flag = true;
				}
			}
			if(flag == false)
			{
				return false;
			}
		}
		return true;
	}

	public static int Pegs_Check(String x, int guesses){
		int black_Pegs=0;
		String[] comparison = new String[GameConfiguration.pegNumber];
		for(int i=0; i<GameConfiguration.pegNumber; i+=1){
			comparison[i] = Answer[i];
		}
		String[] answer=new String[GameConfiguration.pegNumber];
		for(int i=0; i<GameConfiguration.pegNumber; i+=1){
			answer[i] = Character.toString(x.charAt(i));
		}
		for(int element=0; element<GameConfiguration.pegNumber; element +=1){
			for(int index=0; index<Answer.length; index+=1){
				if(answer[element].equals(comparison[index]) && element == index){
					black_Pegs+=1;
					comparison[index]="0";
					answer[element]="1";
				}
			}
		}
		int white_Pegs=0;
		for(int element = 0; element<GameConfiguration.pegNumber;element +=1){
			for(int index=0;  index<comparison.length; index+=1){
				if(answer[element].equals(comparison[index]) && element != index){
					white_Pegs+=1;
					comparison[index]="0";
					answer[element]="1";
				}
			}
		}
		History[guesses]= x;
		Black_Peg_H[guesses]=black_Pegs;
		White_Peg_H[guesses]=white_Pegs;
		System.out.println(x + " -> Result: " + black_Pegs + " black peg(s) and " + white_Pegs + " white peg(s)");
		return black_Pegs;
	}
	
	public static void History(int guesses){
	for(int i=0;i<guesses;i+=1){
			System.out.println("Guess "+ (i+1) + ": " + History[i] + "		" + History[i] + " -> Result: " + Black_Peg_H[i] + " black peg(s) and " + White_Peg_H[i] + " white peg(s)");
		}
	}
}
