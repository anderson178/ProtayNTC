package ru.my.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;


public class ProductDAO implements DAO {

    private List<Product> products = new ArrayList<>();
//    private TreeSet<Product> products = new TreeSet<>();
//    private TreeMap<Integer, Product> products = new TreeMap<>();


    @Override
    public void add(Product product) {
        products.add(product);
        Collections.sort(products);
//        products.put(product.getPosition(),product);
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    private Integer indexOf(Product product) {
        Integer index = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
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
            products.get(index-1).setName(temp);
            products.get(index).setName(tempDown);
        }
    }

    @Override
    public void moveDown(Product product) {
        Integer index = this.indexOf(product);
        if (index != null &&index < products.size() - 1) {
            String tempUp = products.get(index + 1).getName();
            String temp = products.get(index).getName();
            products.get(index+1).setName(temp);
            products.get(index).setName(tempUp);
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
        List<Product> temp = new ArrayList<>();
//        for(Map.Entry<Integer, Product> entry : products.entrySet()) {
//            temp.add(entry.getValue());
//        }
////        for (Product product : products) {
////            temp.add(product);
////        }
        return products;
    }
}
