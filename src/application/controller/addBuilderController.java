package application.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;

import application.Build;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class addBuilderController implements Initializable{
	
    @FXML
    private JFXTextField textAddress,searchBul,textBiuld;
    @FXML
    private JFXDatePicker estabDate;
    @FXML
    private JFXComboBox<String> builManager;
    @FXML
    private TableView<Build> treeTableB;
    
    private TableColumn<Build, String> addressCol,nameCol;
    private TableColumn<Build, String> managerCol;
    private TableColumn<Build, LocalDate> dateCol;
    
    private ObservableList<Build> builds;
    private int index = -1;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> managerName = getManagerNames();
		builManager.getItems().addAll(managerName);
		initializeTableColumn();
		Main.getCellSearch(treeTableB, builds, searchBul);
		
		
	}
	public ObservableList<String> getManagerNames(){
		
		ObservableList<String> manager = FXCollections.observableArrayList();
		//code From database
		for(int i=0; i<addManagerController.mango.size(); i++) {
			manager.add(addManagerController.mango.get(i).getFullName());
		}
		return manager;
	}
	@FXML
	private void getSelecedManager(MouseEvent event) {
		index = treeTableB.getSelectionModel().getSelectedIndex();
		if(index <= -1) {
			return;
		}
		textAddress.setText(addressCol.getCellData(index));
		textBiuld.setText(nameCol.getCellData(index));
		builManager.getSelectionModel().select(managerCol.getCellData(index));
		estabDate.setValue(dateCol.getCellData(index));
	}
	private boolean isClearAll() {
		if(textAddress.getText().isEmpty()||textBiuld.getText().isEmpty()||
				builManager.getSelectionModel().getSelectedIndex() == -1||
				estabDate.getEditor().getText().isEmpty()){
			return true;
		}
		return false;
	}
	
	@FXML
	private void addButton(ActionEvent event) {
		Build newBul = new Build(textBiuld.getText(), textAddress.getText()
								,estabDate.getValue(),builManager.getValue());
		if(!isClearAll()) {
			treeTableB.getItems().add(newBul);
			textAddress.clear();
			textBiuld.clear();
			builManager.getSelectionModel().select(-1);
			estabDate.getEditor().clear();
		}else {
			JFXDialog ge = Main.dialogInfo("تنبيه", "قم بإدخال جميع البيانات المطلوبة رجاء", HomeController.getInstance().getStackPaneHome());
			ge.show();
		}
	}
	@FXML
	private void deleteButton(ActionEvent event) {
		index = treeTableB.getSelectionModel().getSelectedIndex();
		if(index <= -1) {
			return;
		}
		builds.remove(index);
		isClearAll();
		treeTableB.refresh();
	}
	
	@SuppressWarnings("unchecked")
	public void initializeTableColumn() {
		addressCol = new TableColumn<>("عنوان الفرع");
		addressCol.setPrefWidth(150);
		addressCol.setCellValueFactory(new PropertyValueFactory<>("bulAddress"));
		nameCol = new TableColumn<>("إسم الفرع");
		nameCol.setPrefWidth(150);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("bulName"));
		managerCol = new TableColumn<>("مدير الفرع");
		managerCol.setPrefWidth(150);
		managerCol.setCellValueFactory(new PropertyValueFactory<>("bulManger"));
		dateCol = new TableColumn<>("تاريخ تأسيس الفرع");
		dateCol.setPrefWidth(150);
		dateCol.setCellValueFactory(new PropertyValueFactory<>("bulEstab"));
		builds = FXCollections.observableArrayList();
		builds.addAll(new Build("Mazin","Al_deam",LocalDate.now(),addManagerController.mango.get(0).getFullName()),
				new Build("Ibrahim","Al_sahapha",LocalDate.now(),addManagerController.mango.get(1).getFullName()),
				new Build("Musa","Bury",LocalDate.now(),addManagerController.mango.get(2).getFullName()),
				new Build("Mokhtar","Madani",LocalDate.now(),addManagerController.mango.get(3).getFullName()),
				new Build("Zain","Bahry",LocalDate.now(),addManagerController.mango.get(4).getFullName()),
				new Build("Ahmed","Omdurman",LocalDate.now(),addManagerController.mango.get(5).getFullName()),
				new Build("Ayman","Lybia",LocalDate.now(),addManagerController.mango.get(6).getFullName()),
				new Build("Sami","Alhaj_Yousif",LocalDate.now(),addManagerController.mango.get(7).getFullName()));
		treeTableB.setItems(builds);
		treeTableB.getColumns().setAll(dateCol,addressCol,managerCol,nameCol);
		treeTableB.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
