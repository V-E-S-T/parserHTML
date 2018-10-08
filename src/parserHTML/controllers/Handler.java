package parserHTML.controllers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Handler {

    public Handler() {
    }

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
}
