package ru.my.model;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.10.2019
 */
public interface DAO {
    void add(Product product);

    void remove(Product product);

    void moveUp(Product product);

    void moveDown(Product product);

    List<Product> getList();

    void sort();
}
