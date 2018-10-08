package parserHTML.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    private Button btnSave;

    @FXML
    private TextField textField;

    @FXML
    private TextArea resultField;

    @FXML
    private void handleButtonClicks(ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnRespTime) {
            responseTimeHandler(textField.getText());
        } else if (mouseEvent.getSource() == btnTitle) {
            titleHandler(textField.getText());
        } else if (mouseEvent.getSource() == btnDescription) {
            descriptionHandler(textField.getText());
        } else if (mouseEvent.getSource() == btn_h1_Tag) {
            h1_Handler(textField.getText());
        } else if (mouseEvent.getSource() == btnLinks) {
            refHandler(textField.getText());
        } else if (mouseEvent.getSource() == btnImages) {
            imageHandler(textField.getText());
        } else if (mouseEvent.getSource() == btnSave) {
            saveHandler(mouseEvent);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void responseTimeHandler(String link) {
        try {

            double responseTime;
            Long startTime = System.nanoTime();
            Connection.Response response = Jsoup.connect(link).execute();
            Long endTime = System.nanoTime();
            responseTime = (endTime - startTime)/1000000000.0;
            resultField.setText(String.valueOf(responseTime));
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }

    private void titleHandler(String link) {
        try {

            String title;
            Document document = Jsoup.connect(link).get();
            title = document.title();
            resultField.setText(title);
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }

    private void descriptionHandler(String link) {
        try {

            String description;
            Document document = Jsoup.connect(link).get();
            Elements elements = document.select("meta[name=description]");
            Element el = elements.first();
            if(el != null){
                description = el.attr("content");
                resultField.setText(description);
            } else {
                resultField.setText("Parameter 'description' not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }

    private void h1_Handler(String link) {
        try {

            StringBuilder result = new StringBuilder("");
            Document document = Jsoup.connect(link).get();
            Elements elements = document.getElementsByTag("h1");
            elements.forEach(element -> result.append("\n" + element.ownText() + "\r\n"));
            resultField.setText(result.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }

    private void refHandler(String link) {
        try {

            StringBuilder result = new StringBuilder("");
            Document document = Jsoup.connect(link).get();
            Elements elementLinks = document.select("a[href]");

            for (Element ref : elementLinks) {

                result = result.append("\n" + ref.attr("href") + " : " + ref.text() + "\r\n");

            }
            resultField.setText(result.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }

    private void imageHandler(String link) {
        try {

            StringBuilder result = new StringBuilder("");
            Document document = Jsoup.connect(link).get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {

                result = result.append("\nsrc : " + image.attr("src") + "\r\n");
            }
            resultField.setText(result.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }

    private void saveHandler(ActionEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        Node source = (Node) mouseEvent.getSource();
        Window theStage = source.getScene().getWindow();
        File file = fileChooser.showSaveDialog(theStage);


        if(file != null){
            SaveFile(resultField.getText(), file);
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            resultField.setText("File not saved");
        }
    }
}
