package ru.my.model;

import lombok.*;

@AllArgsConstructor
@Data
public class Product implements Comparable<Product> {
    private Integer position;
    private String name;

    @Override
    public int compareTo(Product o) {
        return this.getPosition() - o.getPosition();
    }
}
