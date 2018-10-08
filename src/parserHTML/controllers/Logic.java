package parserHTML.controllers;

//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logic {

    public static void main(String[] args) throws IOException {
//
//
//
//        String serverResponseCode;
//
//
//
//
//        //------------------Server response time----------------------------------------
//        double responseTime;
//
//        Long startTime = System.nanoTime();
//        Connection.Response response = Jsoup.connect("https://netpeaksoftware.com/").execute();
//        Long endTime = System.nanoTime();
//
//        responseTime = (endTime - startTime)/1000000000.0;
//        //------------------------------------------------------------------------------
//
//        //--------------------Title-----------------------------------------------------
//        String title;
//
//        Document document = Jsoup.connect("https://netpeaksoftware.com/").get();
//
//        title = document.title();
//        //------------------------------------------------------------------------------
//
//        //--------------------Description-----------------------------------------------
//        String description;
//
//        description = document.select("meta[name=description]").first().attr("content");
//        //------------------------------------------------------------------------------
//
//        //--------------------h1 Tag----------------------------------------------------
//        List<String> h1_TagOwnText = new ArrayList<>();
//
//        Elements elements = document.getElementsByTag("h1");
//        elements.forEach(element -> h1_TagOwnText.add(element.ownText()));
//        //------------------------------------------------------------------------------
//
//        //--------------------Links-----------------------------------------------------
//        Map<String, String> links = new HashMap<>();
//
//        Elements elementLinks = document.select("a[href]");
//
//        for (Element link : elementLinks) {
//
//            links.put(link.attr("href"), link.text());
//
////            System.out.println("link : " + link.attr("href"));
////            System.out.println("text : " + link.text());
//        }
//        //------------------------------------------------------------------------------
//
//        //--------------------Images----------------------------------------------------
//
//        Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
//        for (Element image : images) {
//
//            System.out.println("\nsrc : " + image.attr("src"));
//            System.out.println("height : " + image.attr("height"));
//            System.out.println("width : " + image.attr("width"));
//            System.out.println("alt : " + image.attr("alt"));
//
//        }

//                <dependency>
//            <groupId>org.jsoup</groupId>
//            <artifactId>jsoup</artifactId>
//            <version>1.11.3</version>
//        </dependency>




//        try{
//            Connection response = Jsoup.connect("https://netpeaksoftware.com/").method(Connection.Method.GET);
//            response.ignoreHttpErrors(false);
//            org.jsoup.Connection.Response r = response.execute();
//            //serverResponseCode = String.valueOf(r.statusCode());
//            //serverResponseTime = r.
//        }
//        catch (HttpStatusException e) {
//
//            e.printStackTrace();
//        }





        //Elements elements = document.getElementsByTag("meta");



//        for(Element element: elements){
//
//            if (element.hasAttr("name")){
//                Attributes atr = element.attributes();
//
//                for (Attribute attribute: atr){
//
//                    if (attribute.getValue().equals("description")){
//                        description = atr.get("content");
//                    }
//                }
//
//            }
//
//        }




    }
}
