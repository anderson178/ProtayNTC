package ru.my.model;

public interface DAO {
    void add(Product product);
    void remove(Integer position);
    void move(Product product);
}
