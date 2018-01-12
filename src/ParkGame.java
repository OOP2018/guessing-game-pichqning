import java.util.Random;

/**
 * Game of guessing a secret number between 1 and upper bound.
 * @author Piyaphol Wiengperm
 *
 */
public class ParkGame extends NumberGame{
   private int upperBound;
   private int secret;
   private int guesses;

   /**
    * Initialize a new game
    * @param upperBound is the max value for the secret number that more than 1.
    */
   public ParkGame(int  upperBound){
       this.upperBound = upperBound;
       long seed = System.nanoTime();
       Random rand = new Random(seed);
       this.secret = rand.nextInt(upperBound)+1;
       super.setMessage("I'm thinking of a number between 1 and "+upperBound);
   }

    /**
     * check the number that user guess whether it is correct.
     * @return boolean
     */
    @Override
   public boolean guess(int number){
       guesses += 1;
       if (number < 1 || number > upperBound)super.setMessage("The number you guessed is out of bound.");
       else if (number < secret)super.setMessage("The number you guessed is too small.");
       else if (number > secret)super.setMessage("The number you guessed is too large.");
       else if (number == secret){
           super.setMessage("That's right! you got it.");
           return true;
       }
       return false;
   }

   @Override
   public int getUpperBound(){ return upperBound; }

   @Override
   public String toString(){
       return "Try to guess what secret number is.";
   }

   @Override
   public int getCount(){
       return guesses;
   }

}