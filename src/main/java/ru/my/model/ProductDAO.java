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
    public void remove(int index) {
        products.remove(index);

        //products.g
    }

    @Override
    public void moveUp(int index) {
        if (index > 0) {
            Product tempDown = products.get(index - 1);
            Product temp = products.get(index);
            products.set(index - 1, temp);
            products.set(index, tempDown);
        }

    }

    @Override
    public void moveDown(int index) {
        if (index < products.size() - 1) {
            Product tempUp = products.get(index + 1);
            Product temp = products.get(index);
            products.set(index + 1, temp);
            products.set(index, tempUp);
            int p = 0;

        }
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
