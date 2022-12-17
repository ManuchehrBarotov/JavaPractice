package com.PatternsAndMultithreding.BuilderPatter;

public class WebSite {

    private String name;
    private Cms cms;
    private int price;


    public void setName(String name) {
        this.name = name;
    }



    public void setPrice(int price) {
        this.price = price;
    }


    public void setCms(Cms cms) {
        this.cms = cms;
    }

    @Override
    public String toString() {
        return "WebSite{" +
                "name='" + name + '\'' +
                ", cms=" + cms +
                ", price=" + price +
                '}';
    }
}
