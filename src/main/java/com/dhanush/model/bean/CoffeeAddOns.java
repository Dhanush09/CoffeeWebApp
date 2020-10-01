package com.dhanush.model.bean;

public class CoffeeAddOns {
    private String addon;
    private int addon_price;
    private int addon_id;

    public CoffeeAddOns(String addon, int addon_price, int addon_id) {
        this.addon = addon;
        this.addon_price = addon_price;
        this.addon_id = addon_id;
    }

    public int getAddon_id() {
        return addon_id;
    }

    public void setAddon_id(int addon_id) {
        this.addon_id = addon_id;
    }

    public CoffeeAddOns() {

    }

    @Override
    public String toString() {
        return "CoffeeAddOns{" +
                "addon='" + addon + '\'' +
                ", addon_price=" + addon_price +
                '}';
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public int getAddon_price() {
        return addon_price;
    }

    public void setAddon_price(int addon_price) {
        this.addon_price = addon_price;
    }
}
