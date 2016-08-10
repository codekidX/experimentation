package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			StartViewController startViewController = new StartViewController();
			// fxml file is for UI/layout of the screen
			 FXMLLoader loader = new FXMLLoader();
			 // StartView.fxml is for the starting screen that you see with drawer icon etc ..
	            loader.setLocation(Main.class.getResource("StartView.fxml"));
	            
	            // layout should have a controller which controls button click and all other various events
	            loader.setController(startViewController);
	            // parent of all UI components
	            rootLayout = (AnchorPane) loader.load();
	            
	            
	            
	        // Show the scene containing the root layout.
	        Scene scene = new Scene(rootLayout);
	        // Inside Stage --> Scene --> Components
	        // model-view-controller pattern
	        
	        //set title (create Socket Chat | Your name) with server code and let this be client. FOR TESTING
			primaryStage.setTitle("Socket Chat | Ashish");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// for now it launcher the application file with args when u press RUN
		launch(args);
	}
}
