import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game.*/
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		
		// describe the game
		System.out.println( game.toString() );
		
		// This is just an example.
		int guess = 0;
		while(true) {
		System.out.print("Your answer? ");
		guess = console.nextInt();
		boolean correct = game.guess(guess);
		if ( correct == true ) {
			break;
		}
		System.out.println( game.getMessage() ); 
		if (correct == false) continue;
		return guess;
	}
		System.out.println( game.getMessage() ); 
		return guess;
	
}
}
