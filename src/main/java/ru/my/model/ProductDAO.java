package ru.my.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class ProductDAO implements DAO {

    private List<Product> products = new ArrayList<>();


    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void remove(Integer position) {
        //products.g
    }

    @Override
    public void move(Product product) {

    }

    @Override
    public List<Product> getList() {
//        products .add(new Product(1, "bread"));
//        products .add(new Product(2, "tea"));
//        products .add(new Product(3, "milk"));
//        products .add(new Product(4, "meat"));
//        products .add(new Product(5, "bear"));
        return products;
    }
}
