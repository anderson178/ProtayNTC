package ru.my.model;


import java.util.*;
import java.util.stream.IntStream;


public class ProductDAO implements DAO {

    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        Integer index = indexOf(product);
        if (index == null) {
            products.add(product);
        } else {
            products.get(index).setName(product.getName());
        }
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    private Integer indexOf(Product product) {
        Integer index = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPosition().equals(product.getPosition())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void moveUp(Product product) {
        Integer index = this.indexOf(product);
        if (index != null && index > 0) {
            this.changeProducts(index, index - 1);
        }
    }

    private void changeProducts(Integer source, Integer destenation) {
        Product tempSource = products.get(source);
        Product tempDest = products.get(destenation);
        products.set(source, tempDest);
        products.set(destenation, tempSource);
        int p=0;


    }

    @Override
    public void moveDown(Product product) {
        Integer index = this.indexOf(product);
        if (index != null && index < products.size() - 1) {
            this.changeProducts(index, index + 1);
        }
    }


    @Override
    public List<Product> getList() {
        return products;
    }

    @Override
    public List<Product> sort() {
        Collections.sort(products);
        return products;
    }
}
