package com.PatternsAndMultithreding.BuilderPatter;

public class VisitCardWebSite extends WebSiteBuilder{
    @Override
    void createName() {
        super.webSite.setName("Visit card");
    }

    @Override
    void createCms() {
        super.webSite.setCms(Cms.WORDPRESS);
    }

    @Override
    void createPrice() {
        super.webSite.setPrice(500);
    }
}
