package parserHTML.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    private TextField textField;

    @FXML
    private TextArea resultField;

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
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
            description = document.select("meta[name=description]").first().attr("content");
            resultField.setText(description);
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
            elements.forEach(element -> result.append("\n" + element.ownText()));
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

                result = result.append("\n" + ref.attr("href") + " : " + ref.text());

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

                result = result.append("\nsrc : " + image.attr("src"));
            }
            resultField.setText(result.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            resultField.setText("Please enter a valid link");
        }
    }
}
