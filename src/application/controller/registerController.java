package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class registerController implements Initializable{
	
	@FXML
	private Pane content_area;
    @FXML
    private JFXTextField userName,fullName,current_cap;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXRadioButton prim,secondary;
    @FXML
    private ToggleGroup choose;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	NumberValidator validator = new NumberValidator();
    	validator.setMessage("just a number...");
    	validator.setStyle("-jfx-text-fill:#ff0000");
    	//validator.setIcon(new ImageView("error.png"));
    	current_cap.getValidators().add(validator);
    	current_cap.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!newValue) {
					if(!current_cap.validate()) {
						current_cap.clear();
					}
				}
			}
    		
		});
		
	}
    @FXML
    private void registeration(ActionEvent event) {
    	if(!isAllClear()) {
    		userName.clear();
    		password.clear();
    		fullName.clear();
    		current_cap.clear();
    		choose.getSelectedToggle().setSelected(false);
    	}else {
    		JFXDialog dialog = Main.dialogInfo("Warring", "All fields are requiered",LogSignController.getInstance().getStackPane());
    		dialog.show();
    		
    		//System.out.println(prim.isSelected()?"Primary":"Secondary");
    	}
    }
    
    private boolean isAllClear() {
    	if(userName.getText().isEmpty()||password.getText().isEmpty()||
    			fullName.getText().isEmpty()||current_cap.getText().isEmpty()||
    			!(prim.isSelected()||secondary.isSelected()))
    		return true;
		return false;
	}

	@FXML
    private void return_Back(ActionEvent event) {
    	loadPane("/application/fxml/SignIn.fxml");
    }
    private void loadPane(String file) {
    	try {
			Parent fxml = FXMLLoader.load(getClass().getResource(file));
			content_area.getChildren().clear();
			content_area.getChildren().add(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
