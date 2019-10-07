package ru.my.model;

import java.util.List;

public interface DAO {
    void add(Product product);

    void remove(Product product);

    void moveUp(Product product);

    void moveDown(Product product);

    List<Product> getList();

    void sort();
}
