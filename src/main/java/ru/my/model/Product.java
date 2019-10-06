package ru.my.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {
    private int position;
    private String name;
}
