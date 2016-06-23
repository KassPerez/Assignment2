
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
	
	public static void Generate(){
		System.out.println("Generating secret code ....");
		for(int i=0; i<GameConfiguration.pegNumber; i+=1){
			int random = (int)(Math.random()*GameConfiguration.colors.length);
			Answer[i]=GameConfiguration.colors[random];
		}
	}
	
	public static boolean check_input(String x){
		if(x.length()>GameConfiguration.pegNumber || x.length()<GameConfiguration.pegNumber){
			return false;
		}
		for(int element = 0; element < GameConfiguration.pegNumber; element +=1){
			String character = Character.toString(x.charAt(element));
			for(int index=0; index<GameConfiguration.colors.length; index+=1){
				if(character.equals(GameConfiguration.colors[index])){
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
			System.out.println(History[i] + "		" + History[i] + " -> Result: " + Black_Peg_H[i] + " black peg(s) and " + White_Peg_H[i] + " white peg(s)");
		}
	}
}
