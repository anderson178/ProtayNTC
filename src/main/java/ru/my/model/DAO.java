package ru.my.model;

import java.util.List;

public interface DAO {
    void add(Product product);
    void remove(Integer position);
    void move(Product product);
    List<Product> getList();
}
