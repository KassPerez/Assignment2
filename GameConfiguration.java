
/*  * EE422C Project 2 (Mastermind) 
 * Summer 2016
 */
public class GameConfiguration {
	public static final int guessNumber = 12;
	public static final String[] colors = {"B","G","O","P","R","Y"};
	public static final int pegNumber = 4;
	public static String[] Answer = new String[pegNumber];
	public static String[] History = new String[guessNumber];
	public static int[] Black_Peg_H = new int[guessNumber];
	public static int[] White_Peg_H = new int[guessNumber];

	public static void next(int Guesses){
		System.out.println("You have " + Guesses + " guesses left.");
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.print("Enter Guess:");
		return;
	}
	
	public static void Generate(){
		System.out.println("Generating secret code ....");
		for(int i=0; i<pegNumber; i+=1){
			int random = (int)(Math.random()*colors.length);
			Answer[i]=colors[random];
		}
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
	
	public static int Pegs_Check(String x, int guesses){
		int black_Pegs=0;
		String[] comparison = new String[pegNumber];
		for(int i=0; i<pegNumber; i+=1){
			comparison[i] = Answer[i];
		}
		String[] answer=new String[pegNumber];
		for(int i=0; i<pegNumber; i+=1){
			answer[i] = Character.toString(x.charAt(i));
		}
		for(int element=0; element<GameConfiguration.pegNumber; element +=1){
			for(int index=0; index<GameConfiguration.Answer.length; index+=1){
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
		GameConfiguration.History[guesses]= x;
		GameConfiguration.Black_Peg_H[guesses]=black_Pegs;
		GameConfiguration.White_Peg_H[guesses]=white_Pegs;
		System.out.println(x + " -> Result: " + black_Pegs + " black peg(s) and " + white_Pegs + " white peg(s)");
		return black_Pegs;
	}
	
	public static void History(int guesses){
		System.out.println(History[guesses] + "		" + History[guesses] + " -> Result: " + Black_Peg_H[guesses] + " black peg(s) and " + White_Peg_H[guesses] + " white peg(s)");
	}
}