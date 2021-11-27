package application;

import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Build {
	
	private String bulName;
	private String bulAddress;
	private LocalDate bulEstab;
	private String bulManger;
	private JFXButton repButton;

	public Build(String bulName, String bulAddress, LocalDate bulEstab, String bulManger) {
		
		this.bulName = bulName;
		this.bulAddress = bulAddress;
		this.bulEstab = bulEstab;
		this.bulManger = bulManger;
		this.repButton = new JFXButton();
		repButton.setOnAction(e -> reports());
	}
	
	private void reports() {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/fxml/continue.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.initStyle(StageStyle.TRANSPARENT);
			scene.setFill(Color.TRANSPARENT);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Action Success ^-^");
	}
	public JFXButton getRepButton() {
		repButton.setFocusTraversable(false);
		repButton.setStyle("-fx-background-radius:200;");
		repButton.setStyle(repButton.getStyle().concat("-fx-background-color:#d82949;"));
		repButton.setGraphic(new ImageView("application/imgs/Copy.png"));
		return repButton;
	}

	public void setRepButton(JFXButton repButton) {
		this.repButton = repButton;
	}

	public String getBulName() {
		return bulName;
	}

	public void setBulName(String bulName) {
		this.bulName = bulName;
	}

	public String getBulAddress() {
		return bulAddress;
	}

	public void setBulAddress(String bulAddress) {
		this.bulAddress = bulAddress;
	}

	public LocalDate getBulEstab() {
		return bulEstab;
	}

	public void setBulEstab(LocalDate bulEstab) {
		this.bulEstab = bulEstab;
	}

	public String getBulManger() {
		return bulManger;
	}

	public void setBulManger(String bulManger) {
		this.bulManger = bulManger;
	}

}
