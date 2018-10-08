package parserHTML.services;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ServiceHandler {

    public ServiceHandler() {
    }

    //handling server response time
    public String responseTimeHandler(String link) {
        try {

            double responseTime;
            Long startTime = System.nanoTime();
            Connection.Response response = Jsoup.connect(link).execute();
            Long endTime = System.nanoTime();
            responseTime = (endTime - startTime)/1000000000.0;
            return String.valueOf(responseTime);
        } catch (Exception e) {
            e.printStackTrace();
            return "Please enter a valid link";
        }
    }

    //handling 'title' site parameter
    public String titleHandler(String link) {
        try {

            String title;
            Document document = Jsoup.connect(link).get();
            title = document.title();
            return title;
        } catch (Exception e) {
            e.printStackTrace();
            return ("Please enter a valid link");
        }
    }

    //handling 'description' site parameter
    public String descriptionHandler(String link) {
        try {

            String description;
            Document document = Jsoup.connect(link).get();
            Elements elements = document.select("meta[name=description]");
            Element el = elements.first();
            if(el != null){
                description = el.attr("content");
                return description;
            } else {
                return ("Parameter 'description' not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ("Please enter a valid link");
        }
    }

    //handling 'h1' tags on the site
    public String h1_Handler(String link) {
        try {

            StringBuilder result = new StringBuilder("");
            Document document = Jsoup.connect(link).get();
            Elements elements = document.getElementsByTag("h1");
            elements.forEach(element -> result.append("\n" + element.ownText() + "\r\n"));
            return result.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return ("Please enter a valid link");
        }
    }

    //handling 'a' (links) tags on the site
    public String linksHandler(String link) {
        try {

            StringBuilder result = new StringBuilder("");
            Document document = Jsoup.connect(link).get();
            Elements elementLinks = document.select("a[href]");

            for (Element ref : elementLinks) {

                result = result.append("\n" + ref.attr("href") + " : " + ref.text() + "\r\n");

            }
            return result.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return ("Please enter a valid link");
        }
    }

    //handling 'img' (image) tags on the site
    public String imageHandler(String link) {
        try {

            StringBuilder result = new StringBuilder("");
            Document document = Jsoup.connect(link).get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {

                result = result.append("\nsrc : " + image.attr("src") + "\r\n");
            }
            return result.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return ("Please enter a valid link");
        }
    }

    //handling result
    public String saveHandler(ActionEvent mouseEvent, String textArea) {

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        Node source = (Node) mouseEvent.getSource();
        Window theStage = source.getScene().getWindow();
        File file = fileChooser.showSaveDialog(theStage);


        if(file != null){
            return saveFile(textArea, file);
        } else {return ("File can not be saved");}
    }

    //saving result into .txt file
    private String saveFile(String content, File file){
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
            return ("File saved");
        } catch (IOException ex) {
            ex.printStackTrace();
            return ("File can not be saved");
        }
    }

}
