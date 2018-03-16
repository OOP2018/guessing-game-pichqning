import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;
/**
*
* Controller for consolefx FXML contain with handleguessing , invalid and exit.
* @author Pichaaun Popukdee
*
*/


public class Controller extends NumberGame {
    public Random ran = new Random();

    @FXML
    TextField textField;
    @FXML
    Button guess;
    @FXML
    Button exit;
    @FXML
    TextArea Hint;
    @FXML
    Button reset;

    /**Set the secret number**/
    public void setSecret(int upperBound) {
        this.secret = ran.nextInt(upperBound) + 0;
    }

    /**number from random**/
    private int secret;

    /**Count how many times of guessing the secret number.**/
    private Counter guessing;

    public void setCounter(Counter counter) {
        this.guessing = counter;
    }

    /**
    * Event that will show on the consolefx most has for check the input number with secret number.
    *
    */
    public boolean handleGuess(ActionEvent event) {
        try{
        guessing.add(1);
        String text = textField.getText().trim();
        if (textField==null) invalid(textField);
        int number = Integer.parseInt(text);
        textField.setStyle("-fx-border-color: none");
        if (number == secret) {
            Hint.setText("Correct!");
            return true;
        } else if (number < secret) {
            Hint.setText("It's too small!");
            return false;
        } else if (number > secret) {
            Hint.setText("It's too large!");

            return false;}
            catch(Exception e){
            invalid(textField)
            }
        }
        return false;
    }


    @FXML
    /**If there is wrong in put or nothing on textField the border will be red.*/
    public void invalid (TextField textField) {
        textField.setStyle(" -fx-border-color: darkred");
    }

    /**Reset all game*/
    public void reset() {
        guessing.setCount(0);
        textField.clear();
        Hint.clear();
        secret = ran.nextInt(999+0);
    }
    
    /**Close the game*/
    public void exit () {
        System.exit(2);
    }
}
