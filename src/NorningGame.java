import java.util.Random;

/**
 * 
 * Game of guessing a secret number.
 * 
 * @author Pichaaun Popukdee.
 * 
 * 
 * 
 */

public class NorningGame extends NumberGame {
	// *Max value for secret number.
	private int upperBound;

	public int getUpperBound() {
		return this.upperBound;
	}

	// *number from random.
	private int secret;

	// *Count how many times of guessing the secret number.
	private int guessing;

	@Override
	public int getCount() {
		return guessing;
	}

	public NorningGame() {

	}

	/*
	 * Initialize a new game.
	 * 
	 * @param upperBound is max value for guessing.
	 */

	public NorningGame(int upperBound) {
		this.upperBound = upperBound;
		Random ran = new Random();
		this.secret = ran.nextInt(upperBound) + 0;
		// super.setMessage("I'm thinking of a number between 0 and " +
		// Integer.toString(upperBound) );
		this.guessing = 0;

	}

	@Override
	public boolean guess(int number) {
		guessing++;
		if (number == secret) {
			setMessage("Correct!");
			return true;
		} else if (number < secret) {
			setMessage("It's too small!");
			return false;
		} else if (number > secret) {
			setMessage("It's too large!");

			return false;
		}
		return false;
	}

	public String toString() {
		return String.format("Guess a secret number between 0 - %d", this.upperBound);
	}

}
