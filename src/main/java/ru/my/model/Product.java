package ru.my.model;

import org.springframework.stereotype.Component;


public class Product {
    private int position;
    private String name;

    public Product() {

    }
    public Product(Integer position, String name) {
        this.position = position;
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }



    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
