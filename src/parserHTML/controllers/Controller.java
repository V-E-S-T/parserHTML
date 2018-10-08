package parserHTML.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import parserHTML.services.ServiceHandler;
import java.net.URL;
import java.util.*;

@org.springframework.stereotype.Controller
public class Controller implements Initializable{

    @Autowired
    private ServiceHandler serviceHandler;

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
    private Button btnSave;

    @FXML
    private TextField textField;

    @FXML
    private TextArea resultField;

    @FXML
    private void handleButtonClicks(ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnRespTime) {
            String result = serviceHandler.responseTimeHandler(textField.getText());
            resultField.setText(result);
        } else if (mouseEvent.getSource() == btnTitle) {
            String result = serviceHandler.titleHandler(textField.getText());
            resultField.setText(result);
        } else if (mouseEvent.getSource() == btnDescription) {
            String result = serviceHandler.descriptionHandler(textField.getText());
            resultField.setText(result);
        } else if (mouseEvent.getSource() == btn_h1_Tag) {
            String result = serviceHandler.h1_Handler(textField.getText());
            resultField.setText(result);
        } else if (mouseEvent.getSource() == btnLinks) {
            String result = serviceHandler.linksHandler(textField.getText());
            resultField.setText(result);
        } else if (mouseEvent.getSource() == btnImages) {
            String result = serviceHandler.imageHandler(textField.getText());
            resultField.setText(result);
        } else if (mouseEvent.getSource() == btnSave) {
            String result = serviceHandler.saveHandler(mouseEvent, textField.getText());
            resultField.setText(result);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
