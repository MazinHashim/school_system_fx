package application.controller;


import java.io.IOException;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignInController {
	
	@FXML
	private Pane content_area;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXPasswordField password;
    
    @FXML
    private void loginAction(ActionEvent event) {
		String use = userName.getText().trim();
		String pass = password.getText().trim();
		if(use.matches("[Mm]azin")&&pass.matches("[Hh]ashim")) {
			content_area.getScene().getWindow().hide();
			Stage stage = null;
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/Home.fxml"));
				stage = new Stage();
				Main.Visible(stage, root);
			} catch(Exception e) {
				e.printStackTrace();
			}
			userName.clear();
			password.clear();
		}else {
			JFXDialog dialog;
			if(use.matches("") || pass.matches("")) {
				dialog = Main.dialogInfo("Warring", "Please Enter User Name and Password",
										  LogSignController.getInstance().getStackPane());
				dialog.show();
			}else {
				dialog = Main.dialogInfo("Warring", "User Name or Password is wrong",
										  LogSignController.getInstance().getStackPane());
				dialog.show();
			}
		}
    }

	@FXML
	private void registration_form(ActionEvent event) {
    	loadPane("/application/fxml/register.fxml");
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
