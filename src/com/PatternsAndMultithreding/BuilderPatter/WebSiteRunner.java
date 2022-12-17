package com.PatternsAndMultithreding.BuilderPatter;

public class WebSiteRunner {

    public static void main(String[] args) {

        Director director = new Director();
        director.setBuilder(new VisitCardWebSite());

        WebSite webSite = director.webSiteBuilder();
        System.out.println(webSite);
    }
}
