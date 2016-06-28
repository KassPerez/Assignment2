The default settings is set to test mode where the answer will be shown to the user who is guessing.
To change to normal game mode, go into the GameConfiguration.java file and change the boolean testingMode to false.

When the game begins, the user is asked if they will want to play the game, if they do, then type "Y" to play the game or else "N" to exit.

The user will be told how many guesses they have and asked for a guess. The user can type their guess into the console and a result will be given to them if their input is valid.
The user can always type "history" to see their previous guesses and how many pegs they got for each.
The game ends when the user either runs out of guesses, thus causing the player to lose the game or the player can get the correct guess and win the game.

After a game over, the user can type "Y" to play again or "N" to exit.


User can be given more guesses by changed the int guessNumber in GameConfiguration.java.
User can be given more colors to guess by changing String[] colors in GameConfiguration.java.
User can be given a different amount of pegs they need to guess by changing int pegNumber in GameConfiguration.java.


https://github.com/KassPerez/Assignment2.git
github Repository.