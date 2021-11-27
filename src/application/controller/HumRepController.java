package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class HumRepController implements Initializable{
    @FXML
    private TableView<?> tableTech;
    @FXML
    private TableView<?> tableWork;
    @FXML
    private Label labTech;
    @FXML
    private Label labWork;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
