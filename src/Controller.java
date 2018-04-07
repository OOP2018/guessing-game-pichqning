
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;


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

    public void setSecret(SecretNumber secret) {
        this.secret = secret;
    }

    /**number from random**/
    private SecretNumber secret;

    /**Count how many times of guessing the secret number.**/
    private Counter guessing;

    public void setCounter(Counter counter) {
        this.guessing = counter;
    }

    public boolean handleGuess(ActionEvent event) {
        try {
            guessing.add(1);
            String text = textField.getText().trim();
            if (textField == null) invalid(textField);
            int number = Integer.parseInt(text);
            textField.setStyle("-fx-border-color: none");
            if (number == secret.getSecretNumber()) {
                Hint.setText("Correct!");
                return true;
            } else if (number < secret.getSecretNumber()) {
                Hint.setText("It's too small!");
                return false;
            } else if (number > secret.getSecretNumber()) {
                Hint.setText("It's too large!");

                return false;
            }
        }
        catch (Exception e) {
            invalid(textField);
        }
        return false;
    }


    @FXML
    public void invalid (TextField textField) {
        textField.setStyle(" -fx-border-color: darkred");
    }

    public void reset() {
        guessing.setCount(0);
        textField.clear();
        Hint.clear();
        secret.random();
    }

    public void exit () {
        System.exit(2);
    }
}