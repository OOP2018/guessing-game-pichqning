import java.util.Random;

/**
 * The GameSolver Class that automatic find the correct secret number.
 * 
 * @author Pichaaun Popukdee
 *
 */

public class GameSolver {

	/** play the game. */
	public int play(NumberGame game) {
		// describe the game
		System.out.println(game.toString());

		int guess;
		
		//use max and min value for keep the range of random number that we use bisection logic. 
		int max = game.getUpperBound();
		int min = 1;

		while (true) {
			
			guess = min + (max - min) / 2 ;
			//Bisection method find the midpoint.
			
			boolean correct = game.guess(guess);

			if (correct == true) {
				break;
			}
			if (correct == false) {
				if (game.getMessage().contains("too small")) {
					min = guess;
					
				} else if (game.getMessage().contains("too large")) {
					max = guess;
			
				}
				
				continue;
			}
		}
		return guess;

	}
}
