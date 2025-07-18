package com.learn.demo.byJava.model;

public class Car {
    private String Band;
    private String price;
    private String cate;

    public Car() {
    }

    public Car(String band, String price, String cate) {
        Band = band;
        this.price = price;
        this.cate = cate;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getBand() {
        return Band;
    }

    public void setBand(String band) {
        Band = band;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Band='" + Band + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
