package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class CallReqController implements Initializable {
    
	@FXML
    private JFXTextField searchCall;

    @FXML
    private TableView<?> tableCall;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    private void CallManagerAction(ActionEvent event) {
    	System.out.println("Mazin Hashim");
    }
}
