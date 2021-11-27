package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;

public class AltacaleefController implements Initializable{

    @FXML
    private JFXListView<String> tacList;
    @FXML
    private JFXTextField textAdd,textSear;

    private ObservableList<String> list;
    private ObservableList<String> listItem;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tacList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tacList.setItems(getTacList());
		searchInList();
		
	}
	@FXML
	private void searchInList() {
		textSear.textProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				if(textSear.textProperty().get().isEmpty()) {
					tacList.setItems(list);
					return;
				}
				ObservableList<String> searList = FXCollections.observableArrayList();
				ObservableList<String> listItem = tacList.getItems();
				for(int i=0; i<listItem.size(); i++) {
					String value = listItem.get(i).toLowerCase();
					if(value.contains(textSear.getText().toLowerCase()) &&
							value.startsWith(textSear.getText().toLowerCase())) {
						searList.add(listItem.get(i));
						//break;
					}
				}
				tacList.setItems(searList);
			}
		});
	}
    @FXML
    private void addActionButton(ActionEvent event) {
    	JFXDialog dialog;
    	if(!textAdd.getText().isEmpty()) {
    		tacList.getItems().add(textAdd.getText());
        	textAdd.clear();	
    	}else {
    		dialog = Main.dialogInfo("تنبيه", "قم بإدخال تكاليف جديدة",HomeController.getInstance().getStackPaneHome());
    		dialog.show();
    	}
    	
    }
    
    @FXML
    private void deleteActionButton(ActionEvent event) {
    	listItem = tacList.getSelectionModel().getSelectedItems();
    	System.out.println(listItem);
    	System.out.println(list.removeAll(listItem));
    	tacList.refresh();
    	
    }	
	private ObservableList<String> getTacList(){
		list = FXCollections.observableArrayList();
		list.addAll("Mazin","Hashim","Ahmed","Mahjoub");
		return list;
	}
}
