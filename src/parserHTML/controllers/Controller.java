package parserHTML.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button btnRespTime;

    @FXML
    private Button btnTitle;

    @FXML
    private Button btnDescription;

    @FXML
    private Button btnImages;

    @FXML
    private Button btnLinks;

    @FXML
    private Button btn_h1_Tag;

    @FXML
    private TextField textField;

    @FXML
    private TextField resultField;

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnRespTime) {
            loadStage("/parserHTML/fxml/ResponseTime.fxml");
        } else if (mouseEvent.getSource() == btnTitle) {
            loadStage("/parserHTML/fxml/Title.fxml");
        } else if (mouseEvent.getSource() == btnDescription) {
            loadStage("/parserHTML/fxml/Description.fxml");
        } else if (mouseEvent.getSource() == btnImages) {
            loadStage("/parserHTML/fxml/Images.fxml");
        } else if (mouseEvent.getSource() == btnLinks) {
            loadStage("/parserHTML/fxml/Links.fxml");
        } else if (mouseEvent.getSource() == btn_h1_Tag) {
            loadStage("/parserHTML/fxml/h1_Tag.fxml");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void loadStage(String fxml) {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            //ResponseTimeController responseTimeController = loader.getController();
            //responseTimeController.initData(textField.getText());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            //stage.getIcons().add(new Image("/home/icons/icon.png"));

            stage.initModality(Modality.APPLICATION_MODAL);



            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLink(){
        return textField.getText();
    }
}
