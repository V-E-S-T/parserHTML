package parserHTML.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import parserHTML.model.ResponseTime;

import java.net.URL;
import java.util.ResourceBundle;

public class ResponseTimeController implements Initializable{

    @FXML
    public Label responseTime;

    @FXML
    private TextField textField;

    private Controller controller;

    public ResponseTimeController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(
//                    "Home.fxml"));
//            loader.setLocation(location);
//            Parent root = (Parent) loader.load();
//            controller = loader.getController();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        ///initData();
    }

    public void initData(String link){

        //responseTime.setText(controller.getLink());

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(
//                    "Home.fxml"));
//            loader.setLocation(location);
//            Parent root = (Parent) loader.load();
//            Controller controller = loader.getController();
//            //ctrl.init(table.getSelectionModel().getSelectedItem());
//
//
//            responseTime.setText(controller.getLink());
//
////            Parent root = (Parent) loader.load();
////            Scene newScene = new Scene(root);
////            Stage newStage = new Stage();
////            newStage.setScene(newScene);
////            newStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
