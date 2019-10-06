package ru.my.model;

import java.util.List;

public interface DAO {
    void add(Product product);
    void remove(int index);
    void moveUp(int index);
    void moveDown(int index);
    List<Product> getList();
}
