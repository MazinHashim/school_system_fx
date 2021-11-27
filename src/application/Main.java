package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/LogSign.fxml"));
			Visible(primaryStage, root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void Visible(Stage stage,Parent root) {
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.initStyle(StageStyle.TRANSPARENT);
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	public static JFXDialog dialogInfo(String header,String message,StackPane stackPn) {
		Text head = new Text(header);
		Text body = new Text(message);
		head.setFill(Color.RED);
		body.setFont(new Font("Californian FB", 15));
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(head);
		content.setBody(body);
		System.out.println(content.getBody().get(0));
		JFXDialog dialog = new JFXDialog(stackPn,content,JFXDialog.DialogTransition.CENTER);
		JFXButton done = new JFXButton("Done");
		done.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.close();
			}
		});
		content.setActions(done);
		return dialog;
	}
	public static <T> void getCellSearch(TableView<T> table,ObservableList<T> list,TextField search) {
	    	search.textProperty().addListener(new InvalidationListener() {
				@Override
				public void invalidated(Observable observable) {
					if(search.textProperty().get().isEmpty()) {
						table.setItems(list);
						return;
					}
					
					ObservableList<T> tableItems = FXCollections.observableArrayList();
					ObservableList<TableColumn<T, ?>> cols = table.getColumns();
					
					for(int i=0; i<list.size(); i++) {
						for(int j=0; j<cols.size(); j++) {
							String cellValue = cols.get(j).getCellData(list.get(i)).toString();
							cellValue = cellValue.toLowerCase();
							if(cellValue.contains(search.getText().toLowerCase()) && 
									cellValue.startsWith(search.getText().toLowerCase())) {
								tableItems.add(list.get(i));
								break;
							}
						}
					}
					table.setItems(tableItems);
				}
			});
	}
	public static void main(String[] args) {
		launch(args);
	}
}
