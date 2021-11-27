package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LogSignController implements Initializable{

    @FXML
    private Pane content_area;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton close,minus,go_back;
    @FXML
    private StackPane stackPane;
    
    private static LogSignController instance;
    private double x = 0;
    private double y = 0;
    public LogSignController() {
    	instance = this;
	}
    public static LogSignController getInstance() {
    	return instance;
    }
    public StackPane getStackPane() {
    	return stackPane;
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadPane("/application/fxml/SignIn.fxml");
	}
		
    @FXML
    private void window_Option(ActionEvent event) {
    	if(event.getSource() == minus) {
    		Stage stage = (Stage) minus.getScene().getWindow();
			stage.setIconified(true);
    	}
    	if(event.getSource() == close) {
    		Stage stage = (Stage) close.getScene().getWindow();
			stage.close();
			System.exit(0);
    	}
    	if(event.getSource() == go_back) {
    		loadPane("/application/fxml/SignIn.fxml");
    	}
    }
    @FXML
    private void dragged(MouseEvent event) {
    	Node node = (Node)event.getSource();
    	Stage stage = (Stage) node.getScene().getWindow();
    	stage.setX(event.getScreenX()-x);
    	stage.setY(event.getScreenY()-y);
    }

    @FXML
    private void pressed(MouseEvent event) {
    	x = event.getSceneX();
    	y = event.getSceneY();
    }
    private void loadPane(String file) {
    	try {
			Parent fxml = FXMLLoader.load(getClass().getResource(file));
			content_area.getChildren().removeAll();
			content_area.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
