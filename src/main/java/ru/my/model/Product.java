package ru.my.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable, Comparable<Product> {
    private Integer position;
    private String name;

//    @Override
//    public int compare(Product o1, Product o2) {
//        return o1.getPosition() - o2.getPosition();
//    }

    @Override
    public int compareTo(Product o) {
        return this.getPosition() - o.getPosition();
    }
}
