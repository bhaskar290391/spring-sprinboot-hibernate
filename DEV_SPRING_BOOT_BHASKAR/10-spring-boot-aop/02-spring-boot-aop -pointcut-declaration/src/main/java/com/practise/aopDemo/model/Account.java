package com.practise.aopDemo.model;

public class Account {

    private int price;

    private String level;

    public Account(){

    }

    public Account(int price, String level) {
        this.price = price;
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "price=" + price +
                ", level='" + level + '\'' +
                '}';
    }
}
