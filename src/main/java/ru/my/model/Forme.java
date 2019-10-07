package ru.my.model;

//import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Forme {
    public static void main(String[] args) {
        Product product1 = new Product(1, "milk");
        Product product2 = new Product(2, "meat");
        Product product3 = new Product(3, "bear");
        List<Product> list = new ArrayList<>();
        list.add(product1);
        //list.add(product2);
        list.add(product3);

        int index = IntStream.range(0, list.size()).filter(i-> list.get(i).equals(product2)).findFirst().orElse(-1);
        int p=0;

    }
}
