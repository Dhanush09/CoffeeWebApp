package com.dhanush.model.bean;

public class CoffeeSize {
    private String size;
    private int size_price;
    private int size_id;

    public CoffeeSize(String size, int size_price, int size_id) {
        this.size = size;
        this.size_price = size_price;
        this.size_id = size_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public CoffeeSize() {

    }

    @Override
    public String toString() {
        return "CoffeeSize{" +
                "size='" + size + '\'' +
                ", size_price=" + size_price +
                '}';
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSize_price() {
        return size_price;
    }

    public void setSize_price(int size_price) {
        this.size_price = size_price;
    }
}
