
/*  * EE422C Project 2 (Mastermind) 
 * Summer 2016
 */
public class GameConfiguration {
	public static final int guessNumber = 12;
	public static final String[] colors = {"B","G","O","P","R","Y"};
	public static final int pegNumber = 4;

	public static void next(int Guesses){
		System.out.println("You have " + Guesses + " guesses left.");
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.print("Enter Guess:");
		return;
	}
	
	public static boolean check_input(String x){
		if(x.length()>GameConfiguration.pegNumber || x.length()<GameConfiguration.pegNumber){
			return false;
		}
		for(int element = 0; element < GameConfiguration.pegNumber; element +=1){
			String character = Character.toString(x.charAt(element));
			for(int index=0; index<GameConfiguration.colors.length; index+=1){
				if(character.equals(colors[index])){
					if(element==(GameConfiguration.pegNumber-1)){
						return true;
					}
					break;
				}
				if(index==GameConfiguration.colors.length-1){
					return false;
				}
			}
		}
		return false;
	}
}