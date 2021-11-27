package application.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
//import com.jfoenix.controls.JFXTreeTableColumn;

import application.Main;
import application.Manager;
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

public class addManagerController implements Initializable{

	@FXML
	private TableView<Manager> treeTableV;
	@FXML
	private JFXTextField searchMan,textPhone,textUser,textName;
	@FXML
	
	private JFXDatePicker dateOB;
	static ObservableList<Manager> mango;
	private TableColumn<Manager, String> userCol,nameCol,phoneCol;
	private TableColumn<Manager, LocalDate> dateCol;
	private int index = -1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeTableColumn();
		Main.getCellSearch(treeTableV, mango, searchMan);

	}
	@FXML
	private void addButton(ActionEvent event) {
		Manager manag = new Manager(textName.getText(), textUser.getText(),
									textPhone.getText(),dateOB.getValue());
		if(!isClearAll()) {
			treeTableV.getItems().add(manag);
			textName.clear();
			textPhone.clear();
			textUser.clear();
			dateOB.getEditor().clear();
		}else {
			JFXDialog ge = Main.dialogInfo("تنبيه", "قم بإدخال جميع البيانات المطلوبة رجاء", HomeController.getInstance().getStackPaneHome());
			ge.show();
		}
	}
	@FXML
	private void deleteButton(ActionEvent event) {
		index = treeTableV.getSelectionModel().getSelectedIndex();
		if(index <= -1) {
			return;
		}
		mango.remove(index);
		treeTableV.refresh();
	}
	
	private boolean isClearAll() {
		if(textName.getText().isEmpty()||textPhone.getText().isEmpty()||textUser.getText().isEmpty()
				||dateOB.getEditor().getText().isEmpty()){
			return true;
		}
		return false;
	}
	
	@FXML
	private void getSelecedManager(MouseEvent event) {
		index = treeTableV.getSelectionModel().getSelectedIndex();
		if(index <= -1) {
			return;
		}
		textName.setText(nameCol.getCellData(index));
		textPhone.setText(phoneCol.getCellData(index));
		textUser.setText(userCol.getCellData(index));
		dateOB.setValue(dateCol.getCellData(index));
	}
	@SuppressWarnings("unchecked")
	public void initializeTableColumn() {
		userCol = new TableColumn<>("إسم المستخدم");
		userCol.setPrefWidth(150);
		userCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
		nameCol = new TableColumn<>("الأسم الرباعي");
		nameCol.setPrefWidth(150);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		phoneCol = new TableColumn<>("رقم الهاتف");
		phoneCol.setPrefWidth(150);
		phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
		dateCol = new TableColumn<>("تاريخ الميلاد");
		dateCol.setPrefWidth(150);
		dateCol.setCellValueFactory(new PropertyValueFactory<>("DoB"));
		mango = FXCollections.observableArrayList();
		mango.addAll(new Manager("Mazin","Mazoon","0116164408",LocalDate.now()),
				new Manager("Ibrahim","Hema","0965173770",LocalDate.now()),
				new Manager("Musa","Musa","0993393993",LocalDate.now()),
				new Manager("Mokhtar","Mokho","012054201",LocalDate.now()),
				new Manager("Zain","Zain","123",LocalDate.now()),
				new Manager("Ahmed","Hamada","011802556",LocalDate.now()),
				new Manager("Ayman","Emo","0118289431",LocalDate.now()),
				new Manager("Sami","Semsem","0967045845",LocalDate.now()));
		treeTableV.getColumns().setAll(dateCol,phoneCol,nameCol,userCol);
		treeTableV.setItems(mango);
		treeTableV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
//	public JFXTreeTableColumn<Manager, String> tableColumn(String title){
//		JFXTreeTableColumn<Manager, String> Col = new JFXTreeTableColumn<>(title);
//		Col.setPrefWidth(150);
//		
//		return Col;
//	}
}
