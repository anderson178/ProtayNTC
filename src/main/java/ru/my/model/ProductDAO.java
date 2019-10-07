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
            Collections.sort(products);
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
       // Integer pp = IntStream.range(0, products.size()).filter(i -> products.get(i).getPosition().equals(product.getPosition())).findFirst().getAsInt();
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
            String tempDown = products.get(index - 1).getName();
            String temp = products.get(index).getName();
            products.get(index - 1).setName(temp);
            products.get(index).setName(tempDown);
        }
    }

    @Override
    public void moveDown(Product product) {
        Integer index = this.indexOf(product);
        if (index != null && index < products.size() - 1) {
            String tempUp = products.get(index + 1).getName();
            String temp = products.get(index).getName();
            products.get(index + 1).setName(temp);
            products.get(index).setName(tempUp);
            int p = 0;
        }
    }


    @Override
    public List<Product> getList() {
        return products;
    }
}
