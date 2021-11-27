package application.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import application.Build;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MonRepController implements Initializable{

    @FXML
    private TableView<Build> tableView;
    @FXML
    private JFXTextField textMonR;
    
    ObservableList<Build> bul;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Mazin Hashim");
		initializeTableColumn();
		Main.getCellSearch(tableView, bul, textMonR);
	}

	@SuppressWarnings("unchecked")
	private void initializeTableColumn() {
		TableColumn<Build, String> nameCol = new TableColumn<>("الفرع");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("bulName"));
		
		TableColumn<Build, String> manCol = new TableColumn<>("المدير");
		manCol.setCellValueFactory(new PropertyValueFactory<>("bulManger"));
		
		TableColumn<Build, Button> butCol = new TableColumn<>("التقارير");
		butCol.setCellValueFactory(new PropertyValueFactory<>("repButton"));
		
		bul = FXCollections.observableArrayList();
		bul.addAll(new Build("Mazin","Al_deam",LocalDate.now(),addManagerController.mango.get(0).getFullName()),
				new Build("Ibrahim","Al_sahapha",LocalDate.now(),addManagerController.mango.get(1).getFullName()),
				new Build("Musa","Bury",LocalDate.now(),addManagerController.mango.get(2).getFullName()),
				new Build("Mokhtar","Madani",LocalDate.now(),addManagerController.mango.get(3).getFullName()),
				new Build("Zain","Bahry",LocalDate.now(),addManagerController.mango.get(4).getFullName()));
		tableView.setItems(bul);
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.getColumns().addAll(butCol,manCol,nameCol);
	}
}
