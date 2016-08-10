package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;;

public class StartViewController implements Initializable {

    @FXML
    private JFXToolbar toolbar;
	
    @FXML
    private JFXDrawer navDrawer;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger hamButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			VBox vbox = FXMLLoader.load(getClass().getResource("NavigationView.fxml"));
			navDrawer.setSidePane(vbox);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// ham icon related code
		HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition = new HamburgerBackArrowBasicTransition(hamButton);
		
		hamburgerBackArrowBasicTransition.setRate(-1);
		
		hamButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate() * -1);
			hamburgerBackArrowBasicTransition.play();
			
			if(navDrawer.isShown()) {
				navDrawer.close();
			} else {
				navDrawer.open();
			}
			
		});
		
		// toolbar related code
		// f**ck it
		
		
	}

}