import java.util.Random;

public class GameSolver {
	Random ai = new Random();
	/** play the game.*/
	public int play(NumberGame game) {
		// describe the game
		System.out.println( game.toString() );
		
		int guess = 0;
		System.out.print("Your answer? ");
		guess = ai.nextInt(game.getUpperBound()) + 0;
		
		while(true) {
		System.out.print("Your answer? ");
		System.out.println(guess);
		boolean correct = game.guess(guess);
		
		if ( correct == true ) {
			break;
		}
		System.out.println( game.getMessage() ); 
		if (correct == false){ 	
			guess = tester(guess,game.getMessage());
			continue;}
		return guess;
	}
		System.out.println( game.getMessage() ); 
		return guess;
	
}
	public static int tester (int guess , String mes) {
		if (mes.equals("It's too less!")) {
			guess += 5;
		}
		else if (mes.equals("It's too much!")) {
			guess -= 4;
		}
		return guess;
		
		
	}
}
