package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class academikController implements Initializable{
	
    @FXML
    private PieChart second;
    @FXML
    private PieChart frist;
    @FXML
    private PieChart thirdA;
    @FXML
    private PieChart thirdS;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Data> list1 = FXCollections.observableArrayList(
				new PieChart.Data("UnSuccess", 40),
				new PieChart.Data("success", 60));
		frist.setData(list1);
		System.out.println(frist.getData().get(0).getPieValue());
		ObservableList<Data> list2 = FXCollections.observableArrayList(
				new PieChart.Data("UnSuccess", 40),
				new PieChart.Data("success", 60));
		second.setData(list2);
		System.out.println(second.getData().get(0).getPieValue());
		ObservableList<Data> list3 = FXCollections.observableArrayList(
				new PieChart.Data("UnSuccess", 40),
				new PieChart.Data("success", 60));
		thirdA.setData(list3);
		System.out.println(thirdA.getData().get(0).getPieValue());
		ObservableList<Data> list4 = FXCollections.observableArrayList(
				new PieChart.Data("UnSuccess", 40),
				new PieChart.Data("success", 60));
		thirdS.setData(list4);
		System.out.println(thirdS.getData().get(0).getPieValue());
	}

}
