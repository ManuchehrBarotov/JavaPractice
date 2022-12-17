package com.PatternsAndMultithreding.BuilderPatter;

public class Director {
    WebSiteBuilder builder;

    public void setBuilder(WebSiteBuilder builder) {
        this.builder = builder;
    }

    WebSite webSiteBuilder(){
        builder.createWebSite();
        builder.createName();
        builder.createCms();
        builder.createPrice();

        WebSite webSite = builder.getWebSite();
        return webSite;
    }
}
