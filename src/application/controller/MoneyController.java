package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MoneyController implements Initializable{

	@FXML
    private  TextField second,frist,thirdA,third3;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    @FXML
    private void insertMoney(ActionEvent event) {
    	clearAll();
    }
    @FXML
    private void isNumber(KeyEvent event) {
    	if(!event.getCharacter().matches("\\d")){
    		event.consume();
    	}
    	
    }
    private void clearAll() {
    	second.clear();
    	frist.clear();
    	third3.clear();
    	thirdA.clear();
    }

}
