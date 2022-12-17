package com.PatternsAndMultithreding.BuilderPatter;

public abstract class WebSiteBuilder {

    WebSite webSite;

    void createWebSite() {
        this.webSite = new WebSite();
    }

    abstract void createName();

    abstract void createCms();

    abstract void createPrice();


    WebSite getWebSite(){
        return this.webSite;
    }

}
