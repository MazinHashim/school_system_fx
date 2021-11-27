package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HomeController implements Initializable{

    @FXML
    private JFXButton close,min,logout,managers,accounting,builds,requests,
    					Moneys,tacaleef,Receipts,Mawared,acadrep;
    @FXML
    private AnchorPane ancLoad;
    @FXML
    private StackPane stkPane;
    
    private static HomeController instance;
    private double x = 0;
    private double y = 0;
    
    public HomeController() { 
    	instance = this;
	}
    public static HomeController getInstance() {
    	return instance;
    }
    public StackPane getStackPaneHome() {
    	return stkPane;
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadPane("/application/fxml/academik.fxml");
	}
	public void close_min_logout(ActionEvent event) {
		if(event.getSource() == close) {
			Stage stage = (Stage) close.getScene().getWindow();
			stage.close();
		}
		if(event.getSource() == min) {
			Stage stage = (Stage) min.getScene().getWindow();
			stage.setIconified(true);
		}
		if(event.getSource() == logout) {
			logout.getScene().getWindow().hide();
			Stage stage = null;
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/LogSign.fxml"));
				stage = new Stage();
				Main.Visible(stage, root);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

    @FXML
    private void pressed(MouseEvent event) {
    	x = event.getSceneX();
    	y = event.getSceneY();
    }
    @FXML
    private void dragged(MouseEvent event) {
    	Node node = (Node)event.getSource();
    	Stage stage = (Stage)node.getScene().getWindow();
    	stage.setX(event.getScreenX()-x);
    	stage.setY(event.getScreenY()-y);
    }
	public void mainMenu(ActionEvent event) {
		if(event.getSource() == managers) {
			loadPane("/application/fxml/addManager.fxml");
		}
		if(event.getSource() == accounting) {
			loadPane("/application/fxml/addManager.fxml");
		}
		if(event.getSource() == builds) {
			loadPane("/application/fxml/addBuilder.fxml");
		}
		if(event.getSource() == requests) {
			loadPane("/application/fxml/CallReq.fxml");
		}
		if(event.getSource() == Moneys) {
			loadPane("/application/fxml/DetarMon.fxml");
		}
		if(event.getSource() == tacaleef) {
			loadPane("/application/fxml/Altacaleef.fxml");
		}
		if(event.getSource() == Receipts) {
			loadPane("/application/fxml/MonRep.fxml");
		}
		if(event.getSource() == Mawared) {
			loadPane("/application/fxml/HumRes.fxml");
		}
		if(event.getSource() == acadrep) {
			loadPane("/application/fxml/academik.fxml");
		}
	}
	public void loadPane(String fxmlFile) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource(fxmlFile));
			ancLoad.getChildren().clear();
			ancLoad.getChildren().add(pane);
		} catch (IOException e) {
			e.printStackTrace();
			JFXDialog dialog = Main.dialogInfo("Load FXML File", "FXML File does not exisit", stkPane);
			dialog.show();
			
		}
	}

}
