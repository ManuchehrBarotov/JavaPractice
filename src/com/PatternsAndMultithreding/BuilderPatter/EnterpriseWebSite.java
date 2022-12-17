package com.PatternsAndMultithreding.BuilderPatter;

public class EnterpriseWebSite extends WebSiteBuilder {
    @Override
    void createName() {
        super.webSite.setName("Enterprise WebSite");
    }

    @Override
    void createCms() {
        super.webSite.setCms(Cms.ALIFRESCO);
    }

    @Override
    void createPrice() {
        super.webSite.setPrice(1500);
    }
}
