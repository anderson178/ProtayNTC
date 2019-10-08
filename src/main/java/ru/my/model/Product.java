package ru.my.model;

import lombok.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.10.2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Comparable<Product> {
    private Integer position;
    private String name;

    /**
     * Метод необходим для сортировки по номеру позиции
     *
     * @param product - элемент коллекции
     * @return - результат сравнения -1, 1 , 0
     */
    @Override
    public int compareTo(Product product) {
        return this.getPosition() - product.getPosition();
    }
}
