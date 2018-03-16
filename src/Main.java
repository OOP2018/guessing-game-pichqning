import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 * 
 * @author Pichaaun Popukdee
 */
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);

		// upper limit for secret number in guessing game
//		int upperBound = 100;
//		NumberGame game = new NorningGame(upperBound);
//		GameSolver ui = new GameSolver();
//		int solution = ui.play(game);
//		System.out.println("play() returned " + solution);
//		System.out.println("Guessing : " + game.getCount() + " times");
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
		stage.setTitle("Guessing Game");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
