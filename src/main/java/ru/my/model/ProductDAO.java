package ru.my.model;


import java.util.*;
import java.util.stream.IntStream;


public class ProductDAO implements DAO {

    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        int index = indexOf(product);
        if (index == -1) {
            products.add(product);
        } else {
            products.get(index).setName(product.getName());
        }
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    private int indexOf(Product product) {
        return IntStream.range(0, products.size()).filter(i -> products.get(i).getPosition().equals(product.getPosition())).findFirst().orElse(-1);
    }

    @Override
    public void moveUp(Product product) {
        int index = this.indexOf(product);
        if (index > 0) {
            this.changeProducts(index, index - 1);
        }
    }

    private void changeProducts(Integer source, Integer destenation) {
        Product temp = products.get(source);
        products.set(source, products.get(destenation));
        products.set(destenation, temp);
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
    public void sort() {
        Collections.sort(products);
    }
}
