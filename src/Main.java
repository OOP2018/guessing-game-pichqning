import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 * 
 * @author Pichaaun Popukdee
 */
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
	Counter counter = new Counter();

		try {
			URL url = getClass().getResource("consolefx.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: consolefx.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			Controller controller = loader.getController();

			// Dependency Injection:
			controller.setSecret(999);
			controller.setCounter(counter);


			// Build and show the scene
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Guessing Game");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		CounterView view2 = new CounterView(counter);
		counter.addObserver(view2);
		view2.run();
	}
}
