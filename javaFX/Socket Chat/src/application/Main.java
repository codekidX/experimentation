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
			 FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("StartView.fxml"));
	            
	            loader.setController(startViewController);
	            rootLayout = (AnchorPane) loader.load();
	            
	            
	            
	        // Show the scene containing the root layout.
	        Scene scene = new Scene(rootLayout);
			primaryStage.setTitle("Socket Chat | Ashish");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
